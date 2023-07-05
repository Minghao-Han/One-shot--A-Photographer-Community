package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private int user_id;//作者id
    private String title;
    private String content;
    private int total_thumb;
    private int total_collect;
    private int pageView;//浏览量
    private Date createTime;
    public Post(int owner_id, String title, String content, Date createTime) {
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
