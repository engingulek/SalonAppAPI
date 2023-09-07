package com.example.Salon.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bookmarklist")
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "user_id")
    public int user_id;

    @Column(name = "artist_id")
   public int artist_id;

    public BookMarkList(int user_id, int artist_id){
        this.user_id = user_id;
        this.artist_id = artist_id;

    }
}
