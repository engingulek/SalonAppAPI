package com.example.Salon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkListArtistWithService {

    private  int id;

    private int artistId;

    private int userId;
    private String imageUrl;

    private  Float rating;
    private String name;

    private  String bestService;

    private  String locationcity;

    private  Float pay;
}
