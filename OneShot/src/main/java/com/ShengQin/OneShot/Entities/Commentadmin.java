package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;


//评论控制类
//因为有一些我没获取，所以findall需要select 个别的属性

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commentadmin {
    private int id;//自增id
    private int inner_id; //评论在shot上的id
    private int shot_id;
    private int parent_id;
    private int commentator_id;
    private String content;
    private Timestamp time;
    private int is_read;  //数据库里是0或1
    private int receiver_id; //接收评论的人的id
}
