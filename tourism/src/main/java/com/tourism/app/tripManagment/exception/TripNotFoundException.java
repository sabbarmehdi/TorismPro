package com.tourism.app.tripManagment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Trip Not Found!")
public class TripNotFoundException extends RuntimeException {

    public TripNotFoundException() {
    }

    public TripNotFoundException(String message) {
        super(message);
    }
}
