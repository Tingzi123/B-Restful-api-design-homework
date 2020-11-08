package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.User;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }

    public boolean deleteUserById(String userId){
        userRepository.deleteUserById(userId);
        return true;
    }

    public List<User> getUsers(String gender) {
        List<User> users = userRepository.findAllByGender(gender);
        return users;
    }

    public User getUserById(String userId){
        User user=userRepository.findOneById(userId);

        return user;
    }

    public User updateUserById(String userId,User user){
        userRepository.findOneById(userId);
        userRepository.save(user);
        return user;
    }
}
