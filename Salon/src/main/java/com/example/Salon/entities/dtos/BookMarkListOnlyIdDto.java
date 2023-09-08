package com.example.Salon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkListOnlyIdDto {

   private  int id;
   private   int artist_id;

   private int user_id;

}
