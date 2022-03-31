package com.example.demoproject.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    @JsonProperty("chapter_id")
    private int chapterId;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("num")
    private int episodeNum;

    public int getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(int episodeNum) {
        this.episodeNum = episodeNum;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }
}
