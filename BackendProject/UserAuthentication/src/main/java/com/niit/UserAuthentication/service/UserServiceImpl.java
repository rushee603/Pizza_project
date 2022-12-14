package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.UserNotFoundException;
import com.niit.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){this.userRepository=userRepository;}


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
       User user =userRepository.findByUserIdAndPassword(userId,password);
       if(user== null)
       {
           throw new UserNotFoundException();
       }
        return user ;
    }

    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
