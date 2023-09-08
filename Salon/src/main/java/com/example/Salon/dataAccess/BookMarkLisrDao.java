package com.example.Salon.dataAccess;

import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.entities.concretes.BookMarkList;

import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.BookMarkListArtistWithService;
import com.example.Salon.entities.dtos.BookMarkListOnlyIdDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface BookMarkLisrDao extends JpaRepository<BookMarkList,Integer> {

    @Query("Select Count(id) from BookMarkList  where artist_id = :artist_id and user_id = :user_id")
    Integer controlBookMarkList(int user_id,int artist_id);


   /* @Query("Select new com.example.Salon.entities.dtos.BookMarkListOnlyIdDto(id,artist_id,user_id) from BookMarkList  where user_id = :user_id")
    List<BookMarkListOnlyIdDto> getBookMarkListId(int user_id);*/

    @Query("Select new com.example.Salon.entities.dtos.BookMarkListArtistWithService(b.id,ar.id,b.user_id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay) From BookMarkList as b inner join Artist as ar on b.artist_id = ar.id inner join Service as s on s.id = ar.bestserviceid where b.user_id = :user_id group by b.id,ar.id,b.user_id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about")
        List<BookMarkListArtistWithService> getBookMarkArtistResult(int user_id);

    /*@Transactional
    @Modifying
    @Query("Delete From BookMarkList Where user_id = :user_id and artist_id = :artist_id ")
   void deleteArtistFromBookMarkList(@Param("user_id") int user_id, @Param("artist_id")int artist_id);
   // Result deleteByUseridAndArtistid(int user_id , int artist_id);
    /*
   // @Query("Delete from BookMarkList where id = :id")*/

}
