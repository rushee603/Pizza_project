package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.PizzaDTO;
import com.niit.PizzaService.domain.PizzaList;
import com.niit.PizzaService.repository.PizzaListRepository;
import com.niit.PizzaService.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaListlmpl implements PizzaListService {

    @Autowired
    private PizzaListRepository pizzaListRepository;

    @Override
    public PizzaList savePizzaList(PizzaDTO pizzaDTO) {
        Optional<PizzaList> pizzaList = pizzaListRepository.findById(pizzaDTO.getUserId());
        if (pizzaList.isEmpty()) {
            PizzaList newPizzaList = new PizzaList();
            newPizzaList.setUserId(pizzaDTO.getUserId());
            List<String> pizza = new ArrayList<>();
            pizza.add(pizzaDTO.getPizzaId());
            newPizzaList.setPizzaId(pizza);
            return pizzaListRepository.save(newPizzaList);}
        else {
            PizzaList existingPizzaList = pizzaList.get();
            List<String> pizza = existingPizzaList.getPizzaId();
            pizza.add(pizzaDTO.getPizzaId());
            existingPizzaList.setPizzaId(pizza);
            return pizzaListRepository.save(existingPizzaList);
        }

    }
    @Override
    public PizzaList findPizzaList(String userId) {
        Optional<PizzaList> pizzaList = pizzaListRepository.findById(userId);
        return pizzaList.get();
    }
}
