package com.example.demoproject.service.impl;

import com.example.demoproject.config.CacheKeyManager;
import com.example.demoproject.model.entity.Video;
import com.example.demoproject.model.entity.VideoBanner;
import com.example.demoproject.mapper.VideoMapper;
import com.example.demoproject.service.VideoService;
import com.example.demoproject.utils.BaseCache;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {

        try{

            Object cacheObj =  baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST,()->{

                List<Video> videoList = videoMapper.listVideo();

                return videoList;

            });

            if(cacheObj instanceof List){
                List<Video> videoList = (List<Video>)cacheObj;
                return videoList;
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {

        try{

            Object cacheObj =  baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{

                List<VideoBanner> bannerList =  videoMapper.listVideoBanner();

                System.out.println("get banner list from DB");

                return bannerList;

            });

            if(cacheObj instanceof List){
                List<VideoBanner> bannerList = (List<VideoBanner>)cacheObj;
                return bannerList;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        //单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);

        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),10000,0.02);
        if(!bloomFilter.mightContain(videoCacheKey)) {
            Video video = videoMapper.findDetailById(videoId);
            bloomFilter.put(videoCacheKey);
            return video;
        }
        try{

            Object cacheObject = baseCache.getOneHourCache().get( videoCacheKey, ()->{

                // 需要使用mybaits关联复杂查询
                Video video = videoMapper.findDetailById(videoId);

                return video;

            });

            if(cacheObject instanceof Video){

                Video video = (Video)cacheObject;
                return video;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


}
