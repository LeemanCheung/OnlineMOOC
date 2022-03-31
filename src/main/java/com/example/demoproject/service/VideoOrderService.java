package com.example.demoproject.service;

import com.example.demoproject.model.entity.Episode;
import com.example.demoproject.model.entity.PlayRecord;
import com.example.demoproject.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int save(int userId, int videoId);

    int record(int userId, int videoId, int episodeNum);

    Episode continuePlay(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
