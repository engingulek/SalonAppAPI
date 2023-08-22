package com.example.Salon.api.controllers;

import com.example.Salon.business.abstracts.TopServiceService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/topServices")
public class TopServiceController {
    private TopServiceService topServiceService;

    @Autowired
    public TopServiceController(TopServiceService topServiceService) {
        super();
        this.topServiceService = topServiceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<TopService>> getAll() {return this.topServiceService.getAll();};
}
