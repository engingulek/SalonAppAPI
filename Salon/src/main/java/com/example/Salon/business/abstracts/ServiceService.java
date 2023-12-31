package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.Service;
import com.example.Salon.entities.dtos.ServiceDto;

import java.util.List;

public interface ServiceService {
    DataResult<List<ServiceDto>> getAll();
}
