package com.example.Salon.business.concretes;

import com.example.Salon.business.abstracts.BookMarkListService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.BookMarkLisrDao;
import com.example.Salon.entities.concretes.BookMarkList;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.BookMarkListArtistWithService;
import com.example.Salon.entities.dtos.BookMarkListOnlyIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMarkListManager implements BookMarkListService {
    private BookMarkLisrDao bookMarkLisrDao;

    @Autowired
    public  BookMarkListManager(BookMarkLisrDao bookMarkLisrDao){
        super();
        this.bookMarkLisrDao = bookMarkLisrDao;
    }



    @Override
    public Result addBookMarkList(BookMarkList bookMarkList) {
      var count =  this.bookMarkLisrDao.controlBookMarkList(bookMarkList.user_id,bookMarkList.artist_id);

      if (count == 0){
          this.bookMarkLisrDao.save(bookMarkList);
          return new Result(true,"Add save");
      }else {
          return  new Result(false,"Alread hava data");
      }

    }

   // @Override
   /* public DataResult<List<BookMarkListOnlyIdDto>> getBookMarkListId(int user_id) {
        return new SuccessDataResult<List<BookMarkListOnlyIdDto>>(this.bookMarkLisrDao.getBookMarkListId(user_id),"Data Listed");
    }*/




    @Override
    public DataResult<List<BookMarkListArtistWithService>> getBookMarkArtistResult(int user_id) {
        return new  SuccessDataResult<List<BookMarkListArtistWithService>>(this.bookMarkLisrDao.getBookMarkArtistResult(user_id),"Data Listed");
    }

    @Override
    public Result deleteArtistFromBookMarkList(int id) {
        this.bookMarkLisrDao.deleteById(id);
        return new Result(true,"Data Deleted");
    }


    /*public Result deleteArtistFromBookMarkList(int user_id,int artist_id) {
        this.bookMarkLisrDao.deleteArtistFromBookMarkList(user_id,artist_id);
        return  new Result(true,"Data Deleted");
    }*/
}
