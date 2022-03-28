package com.example.demoproject.service;

import com.example.demoproject.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
