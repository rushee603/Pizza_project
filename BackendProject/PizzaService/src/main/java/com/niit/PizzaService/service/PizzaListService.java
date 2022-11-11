package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.PizzaDTO;
import com.niit.PizzaService.domain.PizzaList;

public interface PizzaListService{
    PizzaList savePizzaList(PizzaDTO pizzaDTO);
    PizzaList findPizzaList(String userId);

}
