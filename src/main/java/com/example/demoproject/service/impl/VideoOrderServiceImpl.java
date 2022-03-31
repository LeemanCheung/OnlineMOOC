package com.example.demoproject.service.impl;

import com.example.demoproject.exception.CustomException;
import com.example.demoproject.mapper.EpisodeMapper;
import com.example.demoproject.mapper.PlayRecordMapper;
import com.example.demoproject.mapper.VideoMapper;
import com.example.demoproject.mapper.VideoOrderMapper;
import com.example.demoproject.model.entity.Episode;
import com.example.demoproject.model.entity.PlayRecord;
import com.example.demoproject.model.entity.Video;
import com.example.demoproject.model.entity.VideoOrder;
import com.example.demoproject.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;



    @Autowired
    private VideoMapper videoMapper;


    @Autowired
    private EpisodeMapper episodeMapper;


    @Autowired
    private PlayRecordMapper playRecordMapper;


    /**
     * 下单操作
     * 未来版本：优惠券抵扣，风控用户检查，生成订单基础信息，生成支付信息
     * @param userId
     * @param videoId
     * @return
     */
    //加入事物回滚
    @Override
    @Transactional
    public int save(int userId, int videoId) {

        //判断是否已经购买
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
    @Transactional
    public int record(int userId, int videoId, int episodeNum) {

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);

        if(videoOrder==null){return  0;}


        //生成播放记录
        if(videoOrder!=null){
            Episode episode = episodeMapper.findEpisode(videoId,episodeNum);
            if(episode == null){
                throw  new CustomException(-1,"视频没有集信息，请运营人员检查");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional
    public Episode continuePlay(int userId, int videoId) {

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);

        if(videoOrder==null){return  null;}


        //查找播放记录
        if(videoOrder!=null){
            PlayRecord playRecord = playRecordMapper.findPlayRecord(userId, videoId);
            if(playRecord == null){
                throw  new CustomException(-1,"视频没有播放信息，请运营人员检查");
            }
            Episode episode = episodeMapper.findEpisodeById(playRecord.getEpisodeId());
            return episode;
        }

        return null;
    }


    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {

        return videoOrderMapper.listOrderByUserId(userId);
    }
}
