package com.example.demoproject;

import com.example.demoproject.controller.UserController;
import com.example.demoproject.domain.User;
import com.example.demoproject.utils.JsonData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes={DemoProjectApplication.class})//启动整个springboot⼯程
public class UserTest {
    @Autowired
    private UserController userController;
    @Test
    public void loginTest(){
        User user = new User();
        user.setName("ada");
        user.setPwd("123");
        JsonData jsonData = userController.login(user);
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0,jsonData.getCode());
    }
}
