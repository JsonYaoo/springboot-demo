package com.jsonyao.cs.controller;

import com.jsonyao.cs.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot")
public class UserController {

    @Autowired
    private UserSerivce userService;

    @RequestMapping("/getUser/{id}")
    public String GetUser(@PathVariable Long id){
        return userService.findById(id).toString();
    }

    @RequestMapping("/find")
    public String findUser(){
        Long id = 1000l;
        return userService.findById(id).toString();
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

}
