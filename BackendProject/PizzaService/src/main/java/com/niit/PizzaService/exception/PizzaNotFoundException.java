package com.niit.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "PizzaDetails Not Found")
public class PizzaNotFoundException extends Exception {
}
