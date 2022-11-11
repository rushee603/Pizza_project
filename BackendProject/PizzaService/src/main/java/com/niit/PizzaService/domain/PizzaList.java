package com.niit.PizzaService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PizzaList {
    @Id
    private String userId;
    private List<String> pizzaId ;

}
