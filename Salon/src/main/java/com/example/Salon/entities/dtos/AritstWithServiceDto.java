package com.example.Salon.entities.dtos;

import com.example.Salon.entities.concretes.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AritstWithServiceDto {
    private  int id;

    private String imageUrl;

    private  Float rating;
    private String name;

    private  String bestService;

    private  String locationcity;

    private  Float pay;



}
