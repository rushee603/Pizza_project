package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;

import java.util.List;

public interface OrderService {

    Pizza registerPizza(Pizza pizza, byte[] bytes);
    List<Pizza> getAllPizzaDetail();
    Pizza findByPizzaId(String pizzaId);
}
