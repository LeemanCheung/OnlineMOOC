package com.example.demoproject.service.impl;

import com.example.demoproject.model.entity.Video;
import com.example.demoproject.model.entity.VideoBanner;
import com.example.demoproject.mapper.VideoMapper;
import com.example.demoproject.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listBanner() {
        return videoMapper.listVideoBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }


}
