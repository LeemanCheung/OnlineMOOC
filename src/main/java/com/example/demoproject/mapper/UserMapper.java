package com.example.demoproject.mapper;

import com.example.demoproject.domain.User;
import jdk.internal.dynalink.beans.StaticClass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {
    private static Map<String, User> userMap = new HashMap<>();

    static{
        userMap.put("ada",new User(1,"ada","123"));
        userMap.put("ben",new User(2,"ben","132"));
        userMap.put("candy",new User(3,"candy","321"));
    }
    public User login(String username, String pwd){
        User user = userMap.get(username);

        if(user == null){
            return null;
        }
        if(user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }

    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }
}
