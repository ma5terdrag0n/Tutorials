package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * User class with emailId as key.
 */
@AllArgsConstructor
@Getter
public class User implements Serializable {
    private final String phone;
    private final String firstName;
    private final String lastName;
    private final String emailId;
    private final String password;
}
