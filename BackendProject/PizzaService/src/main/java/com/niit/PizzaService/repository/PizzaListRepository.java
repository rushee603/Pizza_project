package com.niit.PizzaService.repository;

import com.niit.PizzaService.domain.PizzaList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaListRepository extends MongoRepository<PizzaList,String> {

}
