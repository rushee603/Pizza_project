package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServicelmpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Pizza registerPizza(Pizza pizza, byte[] bytes) {
        if(orderRepository.findById(pizza.getPizzaId()).isPresent()) {return null;}
        pizza.setImg(bytes);
        return orderRepository.save(pizza);
    }
    @Override
    public List<Pizza> getAllPizzaDetail() {
        return orderRepository.findAll();
    }

    public Pizza findByPizzaId(String pizzaId){
        Optional<Pizza> pizza=orderRepository.findById(pizzaId);
        return pizza.get();
    }
}
