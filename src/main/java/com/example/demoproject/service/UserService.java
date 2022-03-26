package com.example.demoproject.service;

import com.example.demoproject.model.entity.User;

import java.util.Map;

public interface UserService {
    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    User findByUserId(Integer userId);


    String findByPhoneAndPwd(String phone, String pwd);
}
