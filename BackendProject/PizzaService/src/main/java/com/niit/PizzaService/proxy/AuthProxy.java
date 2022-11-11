package com.niit.PizzaService.proxy;


import com.niit.PizzaService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="auth-service")
public interface AuthProxy {

    @PostMapping("customer/register")
    public ResponseEntity saveUser(@RequestBody User user);

}
