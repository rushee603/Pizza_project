package com.niit.PizzaService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    @Id
    private String email;
    private String address;
    private String phoneNumber;

    private List<Pizza> PizzaList;
//  @Transient
    private String userId;
    @Transient
    private String password;


}
