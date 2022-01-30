package com.footballinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Unable to find Jersey")
public class JerseyNotFoundException extends RuntimeException {

    public JerseyNotFoundException(String message) {
        super(message);
    }
}
