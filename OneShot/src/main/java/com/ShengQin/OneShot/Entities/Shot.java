package com.ShengQin.OneShot.Entities;

import lombok.Data;

import java.util.Date;


@Data
public class Shot {
    private int id;
    private int user_id;//该shot属于谁
    private String title;
    private String content;
    private int total_thumb;
    private int total_collect;
    private int pageView;//浏览量
    private Date createTime;

    public Shot(){}

    public Shot(int id, int user_id, String title, String content, int total_thumb, int total_collect, int pageView, Date createTime) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.total_thumb = total_thumb;
        this.total_collect = total_collect;
        this.pageView = pageView;
        this.createTime = createTime;
    }

    public Shot(int owner_id, String title, String content, Date createTime) {
        this.user_id = owner_id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        total_collect=0;
        total_thumb=0;
        pageView=0;
    }
    public void addThumb(){
        total_thumb++;
    }
    public void subThumb(){
        total_thumb--;
    }
    public void addCollect(){
        total_collect++;
    }
    public void subCollect(){
        total_collect--;
    }
    public void addPageView(){
        pageView++;
    }
}
