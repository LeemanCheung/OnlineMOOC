package com.example.demoproject.mapper;

import com.example.demoproject.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
