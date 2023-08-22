package com.example.Salon.business.concretes;

import com.example.Salon.business.abstracts.ArtistService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.ArtistDao;
import com.example.Salon.entities.concretes.Artist;

import com.example.Salon.entities.dtos.AritstWithServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistManager implements ArtistService {



    private ArtistDao artistDao;
    @Autowired
    public ArtistManager(ArtistDao artistDao) {
        super();
        this.artistDao = artistDao;
    }
    @Override
    public DataResult<List<AritstWithServiceDto>> getAll() {
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getall(),"Data Listed");
    }
}
