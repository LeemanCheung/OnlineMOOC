package com.example.demoproject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable {

    private Integer id;

    private  String title;

    private String summary;


    private Integer price;

    @JsonProperty("cover_img")
    private  String coverImg;

    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd-hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date createTime;

    private Double point;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Chapter> chapterList;

    public Video(){}

    public Video(int id, String title){
        this.id = id;
        this.title = title;
        this.createTime = new Date();
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", point=" + point +
                ", characterList=" + chapterList +
                '}';
    }
}
