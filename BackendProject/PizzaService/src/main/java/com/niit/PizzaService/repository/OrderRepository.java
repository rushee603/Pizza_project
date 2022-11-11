package com.niit.PizzaService.repository;

import com.niit.PizzaService.domain.Pizza;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Pizza,String> {




}
