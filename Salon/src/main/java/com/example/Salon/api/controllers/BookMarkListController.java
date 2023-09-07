package com.example.Salon.api.controllers;

import com.example.Salon.business.abstracts.BookMarkListService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.entities.concretes.BookMarkList;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.BookMarkListOnlyIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bookMarkList")
public class BookMarkListController {

    private BookMarkListService bookMarkListService;

    @Autowired
    public  BookMarkListController(BookMarkListService bookMarkListService){
        this.bookMarkListService = bookMarkListService;
    }
// @RequestParam("user_id") int user_id, @RequestParam("artist_id") int artist_id
    @PostMapping("/add")
    public Result add(@RequestBody @Validated BookMarkList bookMarkList){
        return  this.bookMarkListService.addBookMarkList(bookMarkList);
    }

    @GetMapping("/bookMarkListId")
    public DataResult<List<Integer>> getBookMarkListId(@RequestParam("user_id") int user_id){
        return  this.bookMarkListService.getBookMarkListId(user_id);
    }

    @GetMapping("/bookMarkList")
    public  DataResult<List<AritstWithServiceDto>> getBookMarkList(@RequestParam("user_id") int user_id){
        return this.bookMarkListService.getBookMarkArtistResult(user_id);
    }
}
