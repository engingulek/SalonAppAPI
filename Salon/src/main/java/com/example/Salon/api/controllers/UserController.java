package com.example.Salon.api.controllers;


import com.example.Salon.business.abstracts.UserService;
import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.SignIn;
import com.example.Salon.entities.concretes.User;
import com.example.Salon.entities.concretes.UserUpdate;
import com.example.Salon.entities.dtos.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/userInfo")
    public DataResult<UserInfoDto> getUserInfo(@RequestParam("id") int id){
        return  this.userService.getUserInfo(id);
    }

    @PostMapping("/userCreate")
    public  DataResult<UserInfoDto> createUser(@RequestBody @Validated User user){
        return  this.userService.createAccount(user);
    }

    @PostMapping("/singIn")
    public  DataResult<UserInfoDto> singInUser(@RequestBody @Validated SignIn signIn){
        return  this.userService.singInAccount(signIn.email,signIn.password);
    }


    @PostMapping("/userUpdate")
    public  DataResult<UserInfoDto> updateUser(@RequestBody @Validated UserUpdate userUpdate){
        return  this.userService.updateUser(userUpdate);
    }




}
