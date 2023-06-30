package com.ShengQin.OneShot.VO;

import com.ShengQin.OneShot.Entities.Shot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ShotVO {//相比Shot增加作者用户名，仅用来向前端传数据用
    private int id;
    private int user_id;//作者id
    private String user_name;//作者用户名
    private String title;
    private String content;
    private int total_thumb;
    private int total_collect;
    private int pageView;//浏览量
    private Date createTime;
}
