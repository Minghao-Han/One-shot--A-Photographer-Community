package com.ShengQin.OneShot.VO;

import com.ShengQin.OneShot.Entities.Shot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;
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
    private String createTime;
    private boolean thumbed;
    private boolean collected;

    public ShotVO(int id, int user_id, String user_name, String title, String content, int total_thumb, int total_collect, int pageView, Date time, boolean thumbed, boolean collected) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.title = title;
        this.content = content;
        this.total_thumb = total_thumb;
        this.total_collect = total_collect;
        this.pageView = pageView;
        this.thumbed = thumbed;
        this.collected = collected;
        StringBuilder timeStr = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);					//放入Date类型数据
        int year = calendar.get(Calendar.YEAR);					//获取年份
        int month = calendar.get(Calendar.MONTH)+1;					//获取月份
        String monthStr = String.format("%02d", month);
        //calendar的月从0开始但cron从1开始
        int day = calendar.get(Calendar.DATE);					//获取日
        String dayStr = String.format("%02d", day);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);				//时（24小时制）
        String hourStr = String.format("%02d", hour);
        int minute = calendar.get(Calendar.MINUTE);					//分
        String minuteStr = String.format("%02d", minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = String.format("%02d", second);
        timeStr.append(year).append("-").append(monthStr).append("-").append(dayStr).append(" ").append(hourStr).append(":").append(minuteStr).append(":").append(secondStr);
        this.createTime = timeStr.toString();
    }
}
