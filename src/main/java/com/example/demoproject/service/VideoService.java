package com.example.demoproject.service;

import com.example.demoproject.domain.Video;
import com.example.demoproject.domain.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
