package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.Artist;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.ArtitstInfo;


import java.util.List;

public interface ArtistService {
    DataResult<List<AritstWithServiceDto>> getTopArtists();
    //DataResult<List<ArtitstInfo>> getArtistInfo(int artistId);
    DataResult<List<ArtitstInfo>> getArtistInfo(int artistId);
}
