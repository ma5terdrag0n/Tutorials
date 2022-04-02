package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserDoesnotExistsException;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class UserController {

    private static final UserDao userDao = new UserDao();

    @GetMapping(value = "api/v1/user/{id}")
    public User getUser(@PathVariable("id") String emailId) throws UserDoesnotExistsException {
        return userDao.getUser(emailId);
    }

    @GetMapping(value = "api/v1/delete/{id}")
    public boolean delete(@PathVariable("id") String emailId) throws UserDoesnotExistsException {
        return userDao.deleteUser(emailId);
    }

    @PostMapping(value = "api/v1/register", consumes = {"application/json"})
    public User registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        userDao.addUser(user);
        return userDao.getUser(user.getEmailId());
    }
}
