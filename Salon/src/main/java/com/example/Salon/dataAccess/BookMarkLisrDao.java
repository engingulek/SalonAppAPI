package com.example.Salon.dataAccess;

import com.example.Salon.entities.concretes.BookMarkList;

import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.BookMarkListOnlyIdDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface BookMarkLisrDao extends JpaRepository<BookMarkList,Integer> {

    @Query("Select Count(id) from BookMarkList  where artist_id = :artist_id and user_id = :user_id")
    Integer controlBookMarkList(int user_id,int artist_id);


    @Query("Select new com.example.Salon.entities.dtos.BookMarkListOnlyIdDto(artist_id) from BookMarkList  where user_id = :user_id")
    List<BookMarkListOnlyIdDto> getBookMarkListId(int user_id);

    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay) From BookMarkList as b inner join Artist as ar on b.artist_id = ar.id inner join Service as s on s.id = ar.bestserviceid where b.user_id = :user_id group by ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about")
        List<AritstWithServiceDto> getBookMarkArtistResult(int user_id);
}
