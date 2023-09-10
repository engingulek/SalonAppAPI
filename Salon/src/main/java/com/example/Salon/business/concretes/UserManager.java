package com.example.Salon.business.concretes;


import com.example.Salon.business.abstracts.UserService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.core.utilities.results.SuccessDataResult;
import com.example.Salon.dataAccess.UserDao;
import com.example.Salon.entities.concretes.User;
import com.example.Salon.entities.concretes.UserUpdate;
import com.example.Salon.entities.dtos.UserInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements  UserService {

    private UserDao userDao;

    public  UserManager(UserDao userDao){
        super();
        this.userDao = userDao;
    }
    @Override
    public DataResult<UserInfoDto> getUserInfo(int id) {
        return new SuccessDataResult<UserInfoDto>(this.userDao.getUserInfo(id),"Data Listed");
    }

    @Override
    public DataResult<Integer> createAccount(User user) {
        var control = this.userDao.controlUserEmail(user.email);
        if (control == 0){
            var save = this.userDao.save(user);
            var id = save.id;
            return new SuccessDataResult<Integer>(id,"Create User Success");

        }else{
            return new SuccessDataResult<Integer>(-1,"Do not create user");
        }

    }

    @Override
    public DataResult<UserInfoDto> singInAccount(String email, String password) {
        var account =  this.userDao.singInAccount(email,password);
       if (account == null){
           return  new SuccessDataResult<UserInfoDto>(null,false,"Sing In failed");
       }else{
           return  new SuccessDataResult<UserInfoDto>(account,true,"Sing in success");
       }

    }

    @Override
    public DataResult<UserInfoDto> updateUser(UserUpdate userUpdate) {
        var control = this.userDao.controlPassword(userUpdate.id,userUpdate.password);

        if (control == 0){
            return new  SuccessDataResult<UserInfoDto>(null,"Do not update");

        }else{
            Optional<User> userdb = userDao.findById(userUpdate.id);
            User user = userdb.get();
            user.setName(userUpdate.name);
            user.setSurname(userUpdate.surname);
            user.setEmail(userUpdate.email);
            user.setPassword(userUpdate.newPassword);
            user.setImageurl(userUpdate.imageurl);
            userDao.save(user);

            return  new SuccessDataResult<UserInfoDto>(this.userDao.getUserInfo(user.id),"Update Data");

        }
    }


}
