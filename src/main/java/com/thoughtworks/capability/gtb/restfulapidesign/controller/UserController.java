package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.User;
import com.thoughtworks.capability.gtb.restfulapidesign.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/v1")
    public ResponseEntity addUser(@RequestBody User user) {
        boolean result = userService.addUser(user);

        if (!result) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{userId}/v1")
    public ResponseEntity deleteUser(@PathVariable String userId ) {
        boolean result = userService.deleteUserById(userId);

        if (!result) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/v1")
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String gender) {
        List<User> users = userService.getUsers(gender);

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{userId}/v1")
    public ResponseEntity<User> getUserByUserId(@PathVariable String userId) {
        User user = userService.getUserById(userId);

        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/{userId}/v1")
    public ResponseEntity<User> updateUserById(@PathVariable String userId,@RequestBody User user) {
        User userResult = userService.updateUserById(userId,user);

        return ResponseEntity.ok().body(userResult);
    }
}
