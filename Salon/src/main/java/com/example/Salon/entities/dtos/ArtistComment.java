package com.example.Salon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistComment {
    private int id;
    private String imageurl;

    private String  commenter;
   private  String comment;

    private Float rating;

    private  String commentdate;

}
