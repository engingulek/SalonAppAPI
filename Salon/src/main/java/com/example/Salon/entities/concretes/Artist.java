package com.example.Salon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "artists")
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "imageurl")
    private  String imageUrl;

    @Column(name = "bestserviceid")
    private  int bestserviceid;

    @Column(name = "name")
    private  String name;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "locationcity")
    private  String locationcity;

    @Column(name = "pay")
    private Float pay;

    @Column(name = "about")
    private  String about;

    @Column(name = "services")
    private List<Integer> services;

    @Column(name = "number")
    private  String number;


}
