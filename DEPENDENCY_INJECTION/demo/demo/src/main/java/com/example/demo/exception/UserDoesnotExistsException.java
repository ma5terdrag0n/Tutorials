package com.example.demo.exception;

public class UserDoesnotExistsException extends RuntimeException {

    private static final long serialVersionUID = -742632624668240654L;

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
