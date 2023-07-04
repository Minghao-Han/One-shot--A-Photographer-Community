package com.ShengQin.OneShot.Utils;

import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Component
public class CronExpressionGenerator {
    public static String getCronExpression(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);					//放入Date类型数据
        int year = calendar.get(Calendar.YEAR);					//获取年份
        int month = calendar.get(Calendar.MONTH)+1;					//获取月份
        //calendar的月从0开始但cron从1开始
        int day = calendar.get(Calendar.DATE);					//获取日
        int hour = calendar.get(Calendar.HOUR_OF_DAY);				//时（24小时制）
        int minute = calendar.get(Calendar.MINUTE);					//分
        int second = calendar.get(Calendar.SECOND);
        String cronExpression = second+" "+minute+" "+hour+" "+day+" "+month+" ? "+year;
        return cronExpression;
    }
}
