package com.niit.UserAuthentication.domain;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    private String userId;
    private String password;

}
