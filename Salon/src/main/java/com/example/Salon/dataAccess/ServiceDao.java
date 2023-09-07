package com.example.Salon.dataAccess;

import com.example.Salon.entities.concretes.Service;
import com.example.Salon.entities.dtos.ServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceDao extends JpaRepository<Service,Integer> {
    @Query("Select new com.example.Salon.entities.dtos.ServiceDto(s.id,s.name)" +
            "from Service as s order by s.id ASC")
    List<ServiceDto> getAll();
}
