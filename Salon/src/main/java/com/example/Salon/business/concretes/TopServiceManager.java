package com.example.Salon.business.concretes;

import com.example.Salon.business.abstracts.TopServiceService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.TopServiceDao;
import com.example.Salon.entities.concretes.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopServiceManager implements TopServiceService {

   private TopServiceDao topServiceDao;
@Autowired
    public TopServiceManager(TopServiceDao topServiceDao) {
        super();
        this.topServiceDao = topServiceDao;
    }

    @Override
    public DataResult<List<TopService>> getAll() {
        return new SuccessDataResult<List<TopService>>(this.topServiceDao.findAll(),"Data Listed");
    }
}
