package com.example.Salon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private int id;

    private String  name;

    private  String surname;

    private String email;
    private  String imageUrl;

}
