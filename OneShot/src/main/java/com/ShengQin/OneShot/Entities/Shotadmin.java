package com.ShengQin.OneShot.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

import java.security.SecureRandom;


//Shot管理页面

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Shotadmin {
    private  int id;//shot编号
    private  int user_id;//发布者编号
    private String title;
    private String content;
    //private String imgroute; //图片路径
    //点赞、收藏、浏览量、发布时间
    private int total_thumb;
    private int total_collect;
    private int page_view;
    private Timestamp time;
}
