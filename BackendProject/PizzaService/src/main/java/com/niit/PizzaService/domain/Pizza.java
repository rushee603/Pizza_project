package com.niit.PizzaService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Document
@Data
public class Pizza {
    @Id
    private String pizzaId;
    private String pizzaName;
    private int price;
    private String pizzaType;
    private byte[] img;
    }