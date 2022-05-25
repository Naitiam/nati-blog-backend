package com.mine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.core.metrics.StartupStep;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("article_list")
public class Article {
    @TableId(value = "artnum", type = IdType.AUTO)
    private Integer artnum;
    private String arttitle;
    private String artauthor;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date artreltime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date artmodtime;
    private String artcontent;
    private String arttags;
    private String artphoto;
    private Integer artgood;
    private Integer artwatch;
    @TableField(exist=false)
    private List<String> tagsList;

    public Integer getArtnum() {
        return artnum;
    }

    public void setArtnum(Integer artnum) {
        this.artnum = artnum;
    }

    public String getArttitle() {
        return arttitle;
    }

    public void setArttitle(String arttitle) {
        this.arttitle = arttitle;
    }

    public String getArtauthor() {
        return artauthor;
    }

    public void setArtauthor(String artauthor) {
        this.artauthor = artauthor;
    }

    public Date getArtreltime() {
        return artreltime;
    }

    public void setArtreltime(java.util.Date artreltime) {
        this.artreltime = artreltime;
    }

    public Date getArtmodtime() {
        return artmodtime;
    }

    public void setArtmodtime(Date artmodtime) {
        this.artmodtime = artmodtime;
    }

    public String getArtcontent() {
        return artcontent;
    }

    public void setArtcontent(String artcontent) {
        this.artcontent = artcontent;
    }

    public String getArttags() {
        return arttags;
    }

    public void setArttags(String arttags) {
        this.arttags = arttags;
    }

    public String getArtphoto() {
        return artphoto;
    }

    public void setArtphoto(String artphoto) {
        this.artphoto = artphoto;
    }

    public Integer getArtgood() {
        return artgood;
    }

    public void setArtgood(Integer artgood) {
        this.artgood = artgood;
    }

    public Integer getArtwatch() {
        return artwatch;
    }

    public void setArtwatch(Integer artwatch) {
        this.artwatch = artwatch;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

}
