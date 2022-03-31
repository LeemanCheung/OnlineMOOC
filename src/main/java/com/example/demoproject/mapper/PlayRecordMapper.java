package com.example.demoproject.mapper;

import com.example.demoproject.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {
    int saveRecord(PlayRecord playRecord);
    PlayRecord findPlayRecord(@Param("user_id") int userId, @Param("video_id") int videoId);
}
