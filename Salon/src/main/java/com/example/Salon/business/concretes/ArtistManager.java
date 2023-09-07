package com.example.Salon.business.concretes;

import com.example.Salon.business.abstracts.ArtistService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.ArtistDao;
import com.example.Salon.entities.concretes.Artist;

import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.ArtistComment;
import com.example.Salon.entities.dtos.ArtitstInfo;
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
    public DataResult<List<AritstWithServiceDto>> getTopArtists() {
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getTopArtists(),"Data Listed");
    }

    @Override
    public DataResult<List<ArtitstInfo>> getArtistInfo(int artistId) {
        return new SuccessDataResult<List<ArtitstInfo>>(this.artistDao.getArtistInfo(artistId),"Data listed");
    }

    public  DataResult<List<ArtistComment>> getArtistComment(int artistId){
        return  new SuccessDataResult<List<ArtistComment>>(this.artistDao.getArtistComment(artistId),"Data Listed");
    }

    @Override
    public DataResult<List<AritstWithServiceDto>> getSearchArtistResult(String searchText) {
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getSearchArtistResult(searchText),"Data Listed");
    }




    public DataResult<List<AritstWithServiceDto>> getSearchArtistResultFilterService(String searchText,int serviceId) {
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getSearchArtistResultFilterService(searchText,serviceId),"Data Listed");
    }

    //

   public  DataResult<List<AritstWithServiceDto>> getSearchArtistResultOrderPayASC(String searchText){
       return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getSearchArtistResultOrderPayASC(searchText),"Data Listed");
   }
    public  DataResult<List<AritstWithServiceDto>> getSearchArtistResultOrderPayDESC(String searchText){
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getSearchArtistResultOrderPayDESC(searchText),"Data Listed");
    }

    @Override
    public DataResult<List<AritstWithServiceDto>> getSearchArtistResultHighRating(String searchText) {
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getSearchArtistResultHightRating(searchText),"Data Listed");
    }


    /*public DataResult<List<AritstWithServiceDto>> getSearchArtistResultServiceFilter(int serviceId) {
        return new SuccessDataResult<List<AritstWithServiceDto>>(this.artistDao.getSearchArtistResultServiceFilter(serviceId),"Data Listed");
    }*/
}
