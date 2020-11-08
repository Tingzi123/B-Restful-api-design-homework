package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class UserGroupNotFoundException extends RuntimeException {
    public UserGroupNotFoundException(String message) {
        super(message);
    }
}
