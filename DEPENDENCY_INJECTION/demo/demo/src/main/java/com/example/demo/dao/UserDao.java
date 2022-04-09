package com.example.demo.dao;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserDoesnotExistsException;
import com.example.demo.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RMap;

@RequiredArgsConstructor
public class UserDao {

    @NonNull
    private final RMap<String, User> rMap;

    public User getUser(final String userEmailId) {
        if(!rMap.containsKey(userEmailId)) {
            throw new UserDoesnotExistsException("User with email id = " + userEmailId + " doesn't exist.");
        }
        return rMap.get(userEmailId);
    }

    public void addUser(final User user) {
        if(rMap.containsKey(user.getEmailId())) {
            throw new UserAlreadyExistsException("User with email id = " + user.getEmailId() + " already exists.");
        }
        rMap.put(user.getEmailId(), user);
    }

    public boolean deleteUser(final String userEmailId) {
        if(!rMap.containsKey(userEmailId)) {
            throw new UserDoesnotExistsException("User with email id = " + userEmailId + " doesn't exist.");
        }
        rMap.remove(userEmailId);
        return Boolean.TRUE;
    }

}
