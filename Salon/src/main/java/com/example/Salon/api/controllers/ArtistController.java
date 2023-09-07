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

    @GetMapping("/getArtistSearchResult")
    public DataResult<List<AritstWithServiceDto>> getSearchArtistResult(@RequestParam("searchText") String searchText) {
        return this.artistService.getSearchArtistResult(searchText);}



    @GetMapping("/getArtistSearchResultFilterService")
    public DataResult<List<AritstWithServiceDto>> getSearchArtistResult(@RequestParam("searchText") String searchText,@RequestParam("serviceId") int serviceId ) {
        return this.artistService.getSearchArtistResultFilterService(searchText,serviceId);}
    // getSearchArtistResultFilterService



    @GetMapping("/getArtistSearchResultSort")
    public  DataResult<List<AritstWithServiceDto>> getArtistSearchResultSort(@RequestParam("sortType") String sortType,@RequestParam("searchText") String searchText) {
        if (sortType.equals("DESC")){
            return  this.artistService.getSearchArtistResultOrderPayDESC(searchText);
        }
       else if (sortType.equals("ASC")){
            return  this.artistService.getSearchArtistResultOrderPayASC(searchText);
        }
       else {
            return  this.artistService.getSearchArtistResultHighRating(searchText);
        }

    }

    @GetMapping("/getArtistSearchResultOrderPayASC")
    public  DataResult<List<AritstWithServiceDto>> getArtistSearchResultOrderASC(@RequestParam("searchText") String searchText){
        return  this.artistService.getSearchArtistResultOrderPayASC(searchText);
    }

    @GetMapping("/getArtistSearchResultOrderPayDESC")
    public  DataResult<List<AritstWithServiceDto>> getArtistSearchResultOrderDESC(@RequestParam("searchText") String searchText){
        return  this.artistService.getSearchArtistResultOrderPayDESC(searchText);
    }

    @GetMapping("/getArtistSearchResultHighRating")
    public  DataResult<List<AritstWithServiceDto>> getArtistSearchResultHighRating(@RequestParam("searchText") String searchText){
        return  this.artistService.getSearchArtistResultHighRating(searchText);
    }


  /*  @GetMapping("/getSearchArtistResultServiceFilter")
    public DataResult<List<AritstWithServiceDto>> getSearchArtistResultServiceFilter(@RequestParam("serviceId") int serviceId) {
        return  this.artistService.getSearchArtistResultServiceFilter(serviceId);
    }*/

}
