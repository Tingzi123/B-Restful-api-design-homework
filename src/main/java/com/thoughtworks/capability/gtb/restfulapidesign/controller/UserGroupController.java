package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.UserGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.service.UserGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class UserGroupController {
    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @PostMapping(value = "/v1")
    public ResponseEntity<List<UserGroup>> groupUsers() {
        List<UserGroup> userGroups = userGroupService.groupUsers();
        return ResponseEntity.ok().body(userGroups);
    }

    @PatchMapping(value = "/{groupId}/v1")
    public ResponseEntity updateGroupName(@PathVariable String groupId, @RequestBody String groupName) {
        userGroupService.updateGroupName(groupId, groupName);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/v1")
    public ResponseEntity<List<UserGroup>> getAllGroups() {
        List<UserGroup> userGroups = userGroupService.getAllGroups();
        return ResponseEntity.ok().body(userGroups);
    }
}
