package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}