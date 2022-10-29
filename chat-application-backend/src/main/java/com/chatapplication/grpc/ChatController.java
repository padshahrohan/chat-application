package com.chatapplication.grpc;

import com.chatapplication.ChatMessage;
import com.chatapplication.ChatServiceGrpc;
import com.chatapplication.UserId;
import com.chatapplication.group.GroupService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@GrpcService
public class ChatController extends ChatServiceGrpc.ChatServiceImplBase {

    private final boolean isIterativeServer;
    private final GroupService groupService;

    List<ChatMessage> undeliveredMessages = new CopyOnWriteArrayList<>();
    Map<String, StreamObserver<ChatMessage>> activeReceivers = new ConcurrentHashMap<>();

    @Autowired
    public ChatController(@Value("${myserver.iterative}") boolean isIterativeServer, GroupService groupService) {
        this.groupService = groupService;
        System.out.println(isIterativeServer);
        this.isIterativeServer = isIterativeServer;
    }

    @Override
    public void receiveMessages(UserId user, StreamObserver<ChatMessage> responseObserver) {

        System.out.println(undeliveredMessages);
        activeReceivers.put(user.getId(), responseObserver);

        System.out.println(isIterativeServer);
        System.out.println(Thread.currentThread().getName());
        if (isIterativeServer) {
            undeliveredMessages.stream()
                    .filter(m -> m.getTo().equalsIgnoreCase(user.getId()))
                    .findFirst()
                    .ifPresent(m -> {
                        responseObserver.onNext(m);
                        responseObserver.onCompleted();
                        undeliveredMessages.remove(m);
                    });
        } else {
            List<ChatMessage> messagesToDeliver = undeliveredMessages.stream()
                    .filter(m -> m.getTo().equalsIgnoreCase(user.getId()))
                    .collect(Collectors.toList());
            messagesToDeliver.forEach(responseObserver::onNext);
            undeliveredMessages.removeAll(messagesToDeliver);
        }
        System.out.println(activeReceivers);
    }

    @Override
    public void sendMessage(ChatMessage message, StreamObserver<Empty> responseObserver) {
        if (message.getBelongsToGroup()) {
            String groupId = message.getTo();
            groupService.getUsersOfGroup(groupId).stream()
                    .filter(u -> !u.equalsIgnoreCase(message.getFrom()))
                    .forEach(uId -> sendMessageToUser(message, uId));
        } else {
            sendMessageToUser(message, message.getTo());
        }
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();

        System.out.println(activeReceivers);
        System.out.println(undeliveredMessages);
    }

    @Override
    public void removeStream(UserId user, StreamObserver<Empty> responseObserver) {
        activeReceivers.remove(user.getId());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    private void sendMessageToUser(ChatMessage request, String uId) {
        if (activeReceivers.containsKey(uId)) {
            activeReceivers.get(uId).onNext(request);
        } else {
            undeliveredMessages.add(request);
        }
    }
}
