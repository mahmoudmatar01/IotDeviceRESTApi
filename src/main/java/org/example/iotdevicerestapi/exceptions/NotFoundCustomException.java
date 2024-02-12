package org.example.iotdevicerestapi.exceptions;

public class NotFoundCustomException extends RuntimeException {
    public NotFoundCustomException(String message) {
        super(message);
    }
}
