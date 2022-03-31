package com.example.demoproject.mapper;

import com.example.demoproject.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {
    Episode findEpisode(@Param("video_id") int videoId, @Param("num") int episodeNum);
    Episode findEpisodeById(@Param("episode_id") int episodeId);
}
