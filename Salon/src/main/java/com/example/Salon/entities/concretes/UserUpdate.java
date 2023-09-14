package com.example.Salon.entities.concretes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@AllArgsConstructor
@NoArgsConstructor
public class UserUpdate {

    public   int id;


    public   String name;


    public String surname;


    public   String imageurl;


    public   String email;


    public  String password;

    public  String newPassword;


}
