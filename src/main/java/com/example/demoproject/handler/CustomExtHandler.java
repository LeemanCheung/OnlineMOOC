package com.example.demoproject.handler;

import com.example.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class CustomExtHandler {
    @ExceptionHandler(value = Exception.class)
    JsonData handlerException(Exception e, HttpServletRequest request){
        return JsonData.buildError(-2,"server error");
    }
}
