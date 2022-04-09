package com.example.demo.controller;

import com.example.demo.model.ApiError;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserDoesnotExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExistsException.class, UserDoesnotExistsException.class})
    public ResponseEntity<Object> handleConflict(final RuntimeException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.CONFLICT, ex.getLocalizedMessage(), "Error occurred!");
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
