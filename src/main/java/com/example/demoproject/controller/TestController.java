package com.example.demoproject.controller;

import com.example.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class TestController {
    @GetMapping("list")
    public JsonData testExt(){


        int i = 1/0;

        return JsonData.buildSuccess("");


    }
}
