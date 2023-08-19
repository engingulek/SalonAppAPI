package com.example.Salon.dataAccess;

import com.example.Salon.entities.concretes.TopService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopServiceDao extends JpaRepository<TopService,Integer> {



}
