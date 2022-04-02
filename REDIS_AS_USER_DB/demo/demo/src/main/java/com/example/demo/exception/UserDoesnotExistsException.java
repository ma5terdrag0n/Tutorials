package com.example.demo.exception;

public class UserDoesnotExistsException extends RuntimeException {

    public UserDoesnotExistsException(String message) {
        super(message);
    }

    public UserDoesnotExistsException(Throwable cause) {
        super(cause);
    }

    public UserDoesnotExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
