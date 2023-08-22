package com.example.Salon.business.concretes;

import com.example.Salon.business.abstracts.ServiceService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.ServiceDao;
import com.example.Salon.entities.concretes.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceManager implements ServiceService {

    private ServiceDao serviceDao;

    @Autowired
    public ServiceManager(ServiceDao serviceDao) {
        super();
        this.serviceDao = serviceDao;
    }

    @Override
    public DataResult<List<Service>> getAll() {
        return new SuccessDataResult<List<Service>>(this.serviceDao.findAll(),"Data Listed");
    }
}
