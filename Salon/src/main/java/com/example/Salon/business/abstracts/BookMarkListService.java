package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.entities.concretes.BookMarkList;

import com.example.Salon.entities.dtos.AritstWithServiceDto;
import com.example.Salon.entities.dtos.BookMarkListArtistWithService;
import com.example.Salon.entities.dtos.BookMarkListOnlyIdDto;

import java.util.ArrayList;
import java.util.List;

public interface BookMarkListService {
    Result addBookMarkList(BookMarkList bookMarkList);
   // DataResult<List<BookMarkListOnlyIdDto>> getBookMarkListId(int user_id);

    DataResult<List<BookMarkListArtistWithService>> getBookMarkArtistResult(int user_id);

   Result deleteArtistFromBookMarkList(int id);
}


