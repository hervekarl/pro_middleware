package com.herve.pro.intergiciel.Authentification.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class SignUpDto {

    private String lastname;

    private String firstname;

    private String username;

    private Date birthdate;

    private String email;

    private String password;

    private String phone;

}
