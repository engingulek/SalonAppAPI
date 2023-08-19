package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.TopService;

import java.util.List;

public interface TopServiceService {
    DataResult<List<TopService>> getAll();
}
