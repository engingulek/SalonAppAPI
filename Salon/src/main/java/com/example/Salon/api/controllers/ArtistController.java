package com.example.Salon.api.controllers;


import com.example.Salon.business.abstracts.ArtistService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.Artist;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.ArtistComment;
import com.example.Salon.entities.dtos.ArtitstInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artists")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/getTopArtists")
    public DataResult<List<AritstWithServiceDto>> getAll() {return this.artistService.getTopArtists();}

    @GetMapping("/getArtistInfo")
    public  DataResult<List<ArtitstInfo>> getArtistInfo(@RequestParam("artistId")  int artistId) {return  this.artistService.getArtistInfo(artistId);};

    @GetMapping("/getArtistComment")
    public  DataResult<List<ArtistComment>> getArtistComment(@RequestParam("artistId")  int artistId){
        return this.artistService.getArtistComment(artistId);
    }

}
