import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, map, Observable, of, Subject } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "src/models/user.model";
import { ChatMessage, UserId } from "../proto-gen/chat_pb";
import { ChatServiceClient } from "../proto-gen/chat_pb_service";

@Injectable({
    providedIn: 'root',
})
export class ChatApiService {

    userMessages: Map<string, ChatMessage[]> = new Map<string, ChatMessage[]>();

    messageSubject: Subject<ChatMessage> = new Subject<ChatMessage>();
    messageObs$ = this.messageSubject.asObservable();

    url = environment.grpcUrl;
    chatServiceClient = new ChatServiceClient(this.url);

    constructor() { }

    send(message: ChatMessage) {
        this.chatServiceClient.sendMessage(message, (error, resp) => {
            this.addMessageToUserQueue(message.getTo(), message);
        });
    }

    receive(userId: UserId) {
        const stream = this.chatServiceClient.receiveMessages(userId);

        stream.on('data', (message: ChatMessage) => {
            let chatId;
            if (message.getBelongstogroup()) {
                chatId = message.getTo();
            } else {
                chatId = message.getFrom();
            }
            this.messageSubject.next(message);
            this.addMessageToUserQueue(chatId, message);
        });

        stream.on('end', () => {
            console.log('stream ended');
            console.log(environment.isIterative);

            if (environment.isIterative) {
                this.receive(userId);
            }
            
        })
    }

    addMessageToUserQueue(chatId: string, message: ChatMessage) {
    
        let messages = this.userMessages.get(chatId);
        
        if (messages === undefined) {
            messages= [];
        } 
        messages.push(message);
        this.userMessages.set(chatId, messages);
    }

    getChatMessagesFor(chatId: string) {
        return this.userMessages.get(chatId);
    }

    removeStream(userId: string) {
        let user = new UserId();
        user.setId(userId);
        return this.chatServiceClient.removeStream(user, (error, resp) => {
            
        });
    }
    
}