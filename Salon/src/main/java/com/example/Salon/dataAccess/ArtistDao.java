package com.example.Salon.dataAccess;


import com.example.Salon.entities.concretes.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistDao  extends JpaRepository<Artist,Integer> {
}
