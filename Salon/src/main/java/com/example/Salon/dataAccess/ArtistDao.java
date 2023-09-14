package com.example.Salon.dataAccess;


import com.example.Salon.entities.concretes.Artist;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.ArtistComment;
import com.example.Salon.entities.dtos.ArtitstInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistDao  extends JpaRepository<Artist,Integer> {

    // Feth Top Artists
    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay)"+
            "From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where ar.rating >=  3.5")
    List<AritstWithServiceDto> getTopArtists();

    // Fetch Artist Info
@Query(value = "Select new com.example.Salon.entities.dtos.ArtitstInfo(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about,ar.number)"+
        "From Artist as ar "+
        "inner join Service as s on  ar.bestserviceid = s.id Where ar.id=:artistId group by ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about,ar.number") // s.id = ANY(ar.services)
    List<ArtitstInfo> getArtistInfo(int artistId);

// Fetch Artist Comment
@Query(value = "Select new com.example.Salon.entities.dtos.ArtistComment(co.id,cu.imageUrl,cu.nameSurname,co.comment,co.rating,co.commentdate)"
+ "From Comment as co Inner Join Customer as cu on co.customerid = cu.id Where co.artistid =:artistId")
    List<ArtistComment> getArtistComment(int artistId);

// Search Result Artist
    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay)"+
            "From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where Lower(ar.name) LIKE %:searchText%")
    List<AritstWithServiceDto> getSearchArtistResult(String searchText);


    // Search Result artist filter service
    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay) From Artist as ar inner join Service as s on ar.bestserviceid = s.id Where Lower(ar.name) LIKE %:searchText% and s.id = :serviceId")
    List<AritstWithServiceDto> getSearchArtistResultFilterService(String searchText,int serviceId);


    // Sort query

    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay)"+
            "From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where Lower(ar.name) LIKE %:searchText% Order By ar.pay ASC")
    List<AritstWithServiceDto> getSearchArtistResultOrderPayASC(String searchText);

    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay)"+
            "From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where Lower(ar.name) LIKE %:searchText% Order By ar.pay DESC")
    List<AritstWithServiceDto> getSearchArtistResultOrderPayDESC(String searchText);

    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay)"+
            "From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where Lower(ar.name) LIKE %:searchText% Order By ar.rating DESC")
    List<AritstWithServiceDto> getSearchArtistResultHightRating(String searchText);


   /* @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay)"+
            "From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where s.id = :serviceId")
    List<AritstWithServiceDto> getSearchArtistResultServiceFilter(int serviceId);*/




}
