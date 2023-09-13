package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.core.utilities.results.Result;
import com.example.Salon.entities.concretes.User;
import com.example.Salon.entities.concretes.UserUpdate;
import com.example.Salon.entities.dtos.UserInfoDto;

public interface UserService {

    DataResult<UserInfoDto> getUserInfo(int id);

    DataResult<UserInfoDto> createAccount(User user);

    DataResult<UserInfoDto> singInAccount(String email,String password);

    DataResult<UserInfoDto> updateUser(UserUpdate userUpdate);


}
