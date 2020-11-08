package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.UserGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.UserGroupNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserGroupRepository {
    private final List<UserGroup> userGroups = initUserGroups();

    public List<UserGroup> initUserGroups() {
        List<UserGroup> userGroupsInit = new ArrayList<>();
        int groupCounts = 6;
        for (int i = 1; i <= groupCounts; i++) {
            userGroupsInit.add(new UserGroup(""+i,i+"组",i+"组",new ArrayList<>()));
        }
       return userGroupsInit;
    }

    public void save(UserGroup userGroup) {
        userGroups.add(userGroup);
    }

    public UserGroup findOneByGroupId(String groupId) {
        for (UserGroup groupTmp : userGroups) {
            if (groupTmp.getGroupId().equals(groupId)) {
                return groupTmp;
            }
        }
        throw new UserGroupNotFoundException("User group not found");
    }

    public List<UserGroup> findAll() {
        return userGroups;
    }
}
