package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyExistsException;
import com.niit.PizzaService.exception.UserNotFoundException;
import com.niit.PizzaService.proxy.AuthProxy;
import com.niit.PizzaService.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;
    private AuthProxy authProxy;

        @Autowired
        public PizzaServiceImpl(PizzaRepository pizzaRepository, AuthProxy authProxy) {
            this.pizzaRepository =pizzaRepository;
            this.authProxy = authProxy;
        }

        @Override
        public User registerUser(User user) throws UserAlreadyExistsException {
            if (pizzaRepository.findById(user.getEmail()).isPresent()) {throw new UserAlreadyExistsException();}
            ResponseEntity<?> response = authProxy.saveUser(user);
            if (response.getStatusCodeValue() == 201) {
                return pizzaRepository.save(user);}
                else {return null;}
        }

        @Override
        public User savePizzaToList(Pizza pizza, String email) throws UserNotFoundException {    //
            if (pizzaRepository.findById(email).isEmpty()) {throw new UserNotFoundException();}
            User user = pizzaRepository.findByEmail(email);
            if (user.getPizzaList() == null)
            {user.setPizzaList(Arrays.asList(pizza));}
            else
            {
                List<Pizza> pizzas = user.getPizzaList();
                pizzas.add(pizza);
                user.setPizzaList(pizzas);}
                return pizzaRepository.save(user);
        }

   }

