package com.tourism.app.clientManagment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found!")
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException() {
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
