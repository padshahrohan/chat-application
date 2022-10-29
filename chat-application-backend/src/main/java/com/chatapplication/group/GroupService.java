package com.chatapplication.group;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;

    public GroupService(GroupRepository groupRepository, UserGroupRepository userGroupRepository) {
        this.groupRepository = groupRepository;
        this.userGroupRepository = userGroupRepository;
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public void addParticipants(String groupId, List<String> userIds) {

        List<UserGroup> userGroups = userIds.stream().map(uId -> new UserGroup(uId, groupId))
                .collect(Collectors.toList());
        userGroupRepository.saveAll(userGroups);

    }

    public List<Group> getAllGroups(String userId) {
        List<String> groupIds = userGroupRepository.getAllGroupIds(userId);
        Iterable<Group> allById = groupRepository.findAllById(groupIds);
        List<Group> groups = new ArrayList<>();
        allById.forEach(groups::add);
        return groups;
    }

    public List<String> getUsersOfGroup(String groupId) {
        return userGroupRepository.getAllUserIds(groupId);
    }
}
