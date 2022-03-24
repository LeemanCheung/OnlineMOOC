package com.example.demoproject.controller;


import com.example.demoproject.domain.User;
import com.example.demoproject.service.UserService;
import com.example.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {


//    @PostMapping("login")
//    public JsonData login(String pwd, String username){
//        System.out.println("username: "+ username+" pwd: "+pwd);
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    UserService userService;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping("login")
    //accept Json data from body
    public JsonData login(@RequestBody  User user){
        System.out.println("user: "+ user.toString());

        String token = userService.login(user.getUsername(),user.getPwd());

        return token!=null?JsonData.buildSuccess(token):JsonData.buildError("error pwd or username");
    }

    /**
     * 列出全部用户
     * @return
     */
    @GetMapping("list")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }
}
