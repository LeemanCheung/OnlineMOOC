package com.example.demoproject.controller;


import com.example.demoproject.domain.Video;
import com.example.demoproject.domain.VideoBanner;
import com.example.demoproject.service.VideoService;
import com.example.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public JsonData list(){
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }

    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner(){


        List<VideoBanner> bannerList =  videoService.listBanner();



        return JsonData.buildSuccess(bannerList);

    }

    /**
     * 查询视频详情，包含章，集信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true)int videoId){

        Video video = videoService.findDetailById(videoId);

        return JsonData.buildSuccess(video);

    }

//    @PostMapping("save_video_chapter")
//    public JsonData saveVideoChapter(@RequestBody Video video){
//
//        System.out.println(video.toString());
//
//        return JsonData.buildSuccess("");
//    }
}
