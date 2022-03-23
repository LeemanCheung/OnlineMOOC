package com.example.demoproject.mapper;

import com.example.demoproject.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {

        videoMap.put(1, new Video(1,"java"));
        videoMap.put(2, new Video(2,"Spring"));
        videoMap.put(3, new Video(3,"SpringCloud"));
        videoMap.put(4, new Video(4,"C++"));
        videoMap.put(5, new Video(5,"maven"));

    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }
}
