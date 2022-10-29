package com.chatapplication.group;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create")
    public ResponseEntity<Group> createGroup(@RequestBody String name) {
        return new ResponseEntity<>(groupService.createGroup(new Group(name)), HttpStatus.OK);
    }

    @PostMapping("/addParticipants/{groupId}")
    public void addParticipants(@PathVariable("groupId") String groupId, @RequestBody List<String> participants) {
        groupService.addParticipants(groupId, participants);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Group>> getAllGroups(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(groupService.getAllGroups(userId), HttpStatus.OK);
    }


}
