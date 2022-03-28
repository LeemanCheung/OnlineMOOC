package com.example.demoproject.service.impl;

import com.example.demoproject.mapper.VideoMapper;
import com.example.demoproject.mapper.VideoOrderMapper;
import com.example.demoproject.model.entity.Video;
import com.example.demoproject.model.entity.VideoOrder;
import com.example.demoproject.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public int save(int userId, int videoId) {
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);

        if(videoOrder!=null){return  0;}

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);

        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {
        return null;
    }
}
