package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyExistsException;
import com.niit.PizzaService.exception.UserNotFoundException;

public interface PizzaService {

    public User registerUser(User user) throws UserAlreadyExistsException;

    public User savePizzaToList(Pizza pizza, String email) throws UserNotFoundException;//

}