package com.niit.PizzaService.controller;

import com.google.gson.Gson;
import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.PizzaDTO;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyExistsException;
import com.niit.PizzaService.exception.UserNotFoundException;
import com.niit.PizzaService.service.OrderService;
import com.niit.PizzaService.service.PizzaListService;
import com.niit.PizzaService.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("pizza/")
public class PizzaController {

    private ResponseEntity<?> responseEntity;
    Gson gson = new Gson();
    @Autowired
    private OrderService order;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private PizzaListService pizzaListService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {this.pizzaService = pizzaService;}



    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {responseEntity = new ResponseEntity<>(pizzaService.registerUser(user), HttpStatus.CREATED);}
        catch (UserAlreadyExistsException e) {throw new UserAlreadyExistsException();}
        return responseEntity;
    }

    @PostMapping("register/pizza")
    public ResponseEntity<?> registerPizza(@RequestParam("file") MultipartFile file, @RequestParam("details") String details) {
        try {Pizza pizza = gson.fromJson(details, Pizza.class);
        responseEntity = new ResponseEntity<>(order.registerPizza(pizza, file.getBytes()), HttpStatus.OK);}
        catch (IOException e) {throw new RuntimeException(e);}
        return responseEntity;
    }

    @PostMapping("pizzalist")
    public ResponseEntity<?> savePizzaList(@RequestBody PizzaDTO pizzaDTO) {
        return new ResponseEntity<>(pizzaListService.savePizzaList(pizzaDTO), HttpStatus.OK);
    }

    @PostMapping("user/{email}") //
    public ResponseEntity<?> savePizzaToList(@RequestBody Pizza pizza, @PathVariable String email) throws UserNotFoundException {
        try {responseEntity = new ResponseEntity<>(pizzaService.savePizzaToList(pizza, email), HttpStatus.CREATED);}
        catch (UserNotFoundException e) {throw new UserNotFoundException();}
        return responseEntity;
    }

    @GetMapping("showAll")
    public ResponseEntity<?> getAllCustomer() {
        try {responseEntity = new ResponseEntity<>(order.getAllPizzaDetail(), HttpStatus.OK);}
        catch (Exception e) {
        responseEntity = new ResponseEntity<>("Error !!! Try After Sometime.", HttpStatus.INTERNAL_SERVER_ERROR);}
        return responseEntity;
    }
    @GetMapping("getpizzalist/{userId}")
    public ResponseEntity<?> findPizzaList(@PathVariable String userId) {
        return new ResponseEntity<>(pizzaListService.findPizzaList(userId),HttpStatus.OK);
    }

    @GetMapping("pizzaId/{pizzaId}")
    public ResponseEntity<?> findPizza(@PathVariable String pizzaId) {
        return new ResponseEntity<>(order.findByPizzaId(pizzaId),HttpStatus.OK);
    }
 
}