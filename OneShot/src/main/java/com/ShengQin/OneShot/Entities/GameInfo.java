package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

//比赛信息发布
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameInfo {
    private int id; //比赛信息id
    private String title; //比赛标题
    private String content; //比赛内容
    //起始时间与结束时间
    private Date start_time;
    private Date end_time;
    private int winner; //冠军id

}
