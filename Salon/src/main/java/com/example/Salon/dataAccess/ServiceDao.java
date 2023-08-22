package com.example.Salon.dataAccess;

import com.example.Salon.entities.concretes.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDao extends JpaRepository<Service,Integer> {
}
