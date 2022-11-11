package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public User findByUserIdAndPassword(String userId,String password) throws UserNotFoundException;

    List<User> getAllUsers();

}
