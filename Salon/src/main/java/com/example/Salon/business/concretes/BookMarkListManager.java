package com.example.Salon.business.concretes;

import com.example.Salon.business.abstracts.BookMarkListService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.BookMarkLisrDao;
import com.example.Salon.entities.concretes.BookMarkList;
import com.example.Salon.entities.dtos.AritstWithServiceDto;
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

    @Override
    public DataResult<List<Integer>> getBookMarkListId(int user_id) {
        var list = this.bookMarkLisrDao.getBookMarkListId(user_id);
        List<Integer> listId = new ArrayList<Integer>();
        list.forEach(id -> {
            listId.add(id.user_id);

        });
        return  new SuccessDataResult<List<Integer>>(listId,"DataListed");
       /* return  new SuccessDataResult<List<In>>(this.bookMarkLisrDao.getBookMarkListId(user_id),
                "Data Lisrsed");*/
    }

    @Override
    public DataResult<List<AritstWithServiceDto>> getBookMarkArtistResult(int user_id) {
        return new  SuccessDataResult<List<AritstWithServiceDto>>(this.bookMarkLisrDao.getBookMarkArtistResult(user_id),"Data Listed");
    }
}
