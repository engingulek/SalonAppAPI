package com.example.Salon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "topservices")
@AllArgsConstructor
@NoArgsConstructor
public class TopService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "imageurl")
    private  String imageUrl;
    @Column(name = "name")
    private  String name;


}
