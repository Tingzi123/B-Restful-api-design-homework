package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.User;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.UserGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.UserGroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserGroupService {
    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;

    public UserGroupService(UserGroupRepository userGroupRepository, UserRepository userRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
    }

    public List<UserGroup> groupUsers() {
        List<User> usersTmp=new ArrayList<>();
        usersTmp.addAll(userRepository.findAll());

        Collections.shuffle(usersTmp);

        userGroupRepository.initUserGroups();

        int groupNum = 6;
        for (int i = 0; i < usersTmp.size(); i++) {
            userGroupRepository.findOneByGroupId(""+i+1%groupNum).getUsers().add(usersTmp.get(i));
        }

        for (UserGroup ug:userGroupRepository.findAll()){
            Collections.sort(ug.getUsers(), new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
        }

        return userGroupRepository.findAll();
    }

    public void updateGroupName(String groupId, String groupName) {
        UserGroup userGroup = userGroupRepository.findOneByGroupId(groupId);

        userGroup.setGroupName(groupName);

        userGroupRepository.save(userGroup);
    }

    public List<UserGroup> getAllGroups() {
        return userGroupRepository.findAll();
    }
}
