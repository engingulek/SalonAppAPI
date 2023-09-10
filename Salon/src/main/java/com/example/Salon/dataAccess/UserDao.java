package com.example.Salon.dataAccess;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.User;
import com.example.Salon.entities.dtos.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {

   @Query("Select new com.example.Salon.entities.dtos.UserInfoDto(id,name,surname,email,imageurl) From User  where id =:id ")
    UserInfoDto getUserInfo(int id);

   @Query ("Select count(id) from User where email = :email")
    Integer controlUserEmail(String email);


    @Query("Select new com.example.Salon.entities.dtos.UserInfoDto(id,name,surname,email,imageurl) From User  where email =:email and password =:password ")
    UserInfoDto singInAccount(String email ,String password);


    @Query("Select Count(id) from User where id =:id and password =:curPass")
    Integer controlPassword(int id,String curPass);





}
