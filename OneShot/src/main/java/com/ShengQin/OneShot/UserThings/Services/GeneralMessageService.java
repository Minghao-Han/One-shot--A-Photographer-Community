package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.VO.Message;

import java.util.List;

public interface GeneralMessageService {
    public static final int PAGE_SIZE=10;
    public List<Message> getUncheckMessages(int user_id);
    public List<Message> getHistoryMessage(int user_id,int pageOffset);//要有偏移量，偏移量=上次uncheck message的数量，可作为实现类的成员变量
    public void registerSubMessageService();
}
