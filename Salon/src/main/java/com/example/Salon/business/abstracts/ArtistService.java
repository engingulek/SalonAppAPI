package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.Artist;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.ArtistComment;
import com.example.Salon.entities.dtos.ArtitstInfo;


import java.util.List;

public interface ArtistService {
    DataResult<List<AritstWithServiceDto>> getTopArtists();
    //DataResult<List<ArtitstInfo>> getArtistInfo(int artistId);
    DataResult<List<ArtitstInfo>> getArtistInfo(int artistId);

    DataResult<List<ArtistComment>> getArtistComment(int artistId);

    DataResult<List<AritstWithServiceDto>> getSearchArtistResult(String searchText);

    DataResult<List<AritstWithServiceDto>> getSearchArtistResultFilterService(String searchText,int serviceId);



    DataResult<List<AritstWithServiceDto>> getSearchArtistResultOrderPayASC(String searchText);
    DataResult<List<AritstWithServiceDto>> getSearchArtistResultOrderPayDESC(String searchText);

    DataResult<List<AritstWithServiceDto>> getSearchArtistResultHighRating(String searchText);

   // DataResult<List<AritstWithServiceDto>> getSearchArtistResultServiceFilter(int serviceId);
}
