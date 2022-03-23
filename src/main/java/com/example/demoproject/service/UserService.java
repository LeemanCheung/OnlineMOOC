package com.example.demoproject.service;

import com.example.demoproject.domain.User;

import java.util.List;

public interface UserService {
    String login(String username, String pwd);

    List<User> listUser();
}
