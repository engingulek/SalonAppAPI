package com.example.Salon.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "customerid")
    private  int customerid;


    @Column(name = "artistid")
    private  int artistid;

    @Column(name = "rating")
    private  Float rating;

    @Column(name = "comment")
    private  String comment;

    @Column(name = "commentdate")
    private  String commentdate;



}
