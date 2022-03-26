package com.example.demoproject.controller;


import com.example.demoproject.model.request.LoginRequest;
import com.example.demoproject.service.UserService;
import com.example.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {


//    @PostMapping("login")
//    public JsonData login(String pwd, String username){
//        System.out.println("username: "+ username+" pwd: "+pwd);
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    UserService userService;

    /**
     * 注册接口
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo ){
        System.out.println("111");
        int rows = userService.save(userInfo);

        return rows == 1 ? JsonData.buildSuccess(): JsonData.buildError("注册失败，请重试");

    }

    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        return token == null ?JsonData.buildError("登录失败，账号密码错误"): JsonData.buildSuccess(token);

    }

    /**
     * 列出全部用户
     * @return
     */
//    @GetMapping("list")
//    public JsonData listUser(){
//        return JsonData.buildSuccess(userService.listUser());
//    }
}
