package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public boolean save(User user) {
        users.add(user);
        return true;
    }

    public List<User> findAllByGender(String gender) {
        if (gender == null){
            return users;
        }

        List<User> userResult=new ArrayList<>();
        for (User u:users) {
            if (u.getGender().equals(gender)){
                userResult.add(u);
            }
        }

        return userResult;
    }
}
