package com.example.demoproject.controller;

import com.example.demoproject.model.entity.Episode;
import com.example.demoproject.model.entity.PlayRecord;
import com.example.demoproject.model.request.VideoOrderRequest;
import com.example.demoproject.service.VideoOrderService;
import com.example.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("api/v1/pri/play")
public class VideoPlayController {

    @Autowired
    private VideoOrderService videoOrderService;

    @PostMapping("record")
    public JsonData playRecord(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");

        int res = videoOrderService.record(userId, videoOrderRequest.getVideoId(), videoOrderRequest.getEpisodeNum());


        return res == 0 ? JsonData.buildError("记录保存失败"):JsonData.buildSuccess();
    }

    @GetMapping("continue")
    public JsonData playContinue(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");

        Episode episode = videoOrderService.continuePlay(userId, videoOrderRequest.getVideoId());


        return episode == null ? JsonData.buildError("记录保存失败"):JsonData.buildSuccess(episode);
    }

}
