package com.example.Salon.dataAccess;


import com.example.Salon.entities.concretes.Artist;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.ArtitstInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistDao  extends JpaRepository<Artist,Integer> {
   // @Query("Select ar.name,s.name as bestService from Artist as ar inner join Service as s on ar.bestserviceid = s.id ")
   // @Query("Select ar.id,ar.imageUrl,ar.name,ar.rating,ar.locationcity,ar.pay,ar.about,s.name as bestService,ar.rating,array_agg(s) as services from Artist ar inner join Service s on ar.bestserviceid = s.id and s.id = any(ar.services) group by ar.id,ar.name,s.name,ar.rating ")
    // @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.name.s.name) From Service s Inner Join s.artists ar")
    @Query("Select new com.example.Salon.entities.dtos.AritstWithServiceDto(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay) From Artist as ar inner join Service as s on ar.bestserviceid = s.id  Where ar.rating >=  3.5")
    List<AritstWithServiceDto> getTopArtists();



//group by ar.id , ar.imageUrl,ar.name,ar.rating,ar.locationcity,ar.pay,ar.about,s.name
   // @Query("Select new com.example.Salon.entities.ArtitstInfo(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about) From Artist as ar inner join Service as s on ar.bestserviceid = s.id  where ar.id = 1 group by ar.id , ar.imageUrl,ar.name,ar.rating,ar.locationcity,ar.pay,ar.about,s.name")

//@Query("Select new com.example.Salon.entities.dtos.ArtitstInfo(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about,array_agg(s.name)) From Artist as ar inner join Service as s on ar.bestserviceid = s.id inner join Service as se on se.id = ANY(ar.services) where ar.id=:artistId") // s.id = ANY(ar.services)
@Query(value = "Select new com.example.Salon.entities.dtos.ArtitstInfo(ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about) From Artist as ar inner join Service as s on  ar.bestserviceid = s.id Where ar.id=:artistId group by ar.id,ar.imageUrl,ar.rating,ar.name,s.name,ar.locationcity,ar.pay,ar.about") // s.id = ANY(ar.services)
    List<ArtitstInfo> getArtistInfo(int artistId);
}
