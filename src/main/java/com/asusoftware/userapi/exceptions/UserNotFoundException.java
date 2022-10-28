package com.asusoftware.userapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends UserApiException {
    public UserNotFoundException() {
        super("User not found!");
    }
}
