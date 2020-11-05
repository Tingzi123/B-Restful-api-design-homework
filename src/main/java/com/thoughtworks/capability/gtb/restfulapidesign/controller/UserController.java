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

    @PostMapping(value = "/user/v1")
    public ResponseEntity addUser(@RequestBody User user) {
        boolean result = userService.addUser(user);

        if (!result) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users/v1")
    public ResponseEntity getUsers(@RequestParam(required = false) String gender) {
        List<User> users = userService.getUsers(gender);

        return ResponseEntity.ok().body(users);
    }
}
