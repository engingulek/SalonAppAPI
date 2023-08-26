package com.example.Salon.entities.dtos;

import com.example.Salon.entities.concretes.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtitstInfo {
    private  int id;

    private String imageUrl;

    private  Float rating;
    private String name;

    private  String bestService;

    private  String locationcity;

    private  Float pay;

    private  String about;



}
