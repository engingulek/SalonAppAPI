package com.example.Salon.api.controllers;

import com.example.Salon.business.abstracts.ServiceService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.Service;
import com.example.Salon.entities.dtos.ServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/service")
public class ServiceController {
    private ServiceService serviceService;
    @Autowired

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<ServiceDto>> getAll() {return  this.serviceService.getAll();}
}
