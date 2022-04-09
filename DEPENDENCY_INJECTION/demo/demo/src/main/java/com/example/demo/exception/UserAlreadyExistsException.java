package com.example.demo.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = -3585419234290057919L;

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public UserAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
