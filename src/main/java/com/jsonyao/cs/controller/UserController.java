package com.jsonyao.cs.controller;

import com.jsonyao.cs.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boot")
public class UserController {

    @Autowired
    private UserSerivce userService;

    @PostMapping("/test")
    public String test(@RequestBody com.jsonyao.cs.entity.User user){
        System.err.println("test");
        return user.toString();
    }

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

    @RequestMapping("/batchInsert/{size}")
    public String batchInsert(@PathVariable int size){
        userService.batchInsert(size);
        return "成功!";
    }
}
