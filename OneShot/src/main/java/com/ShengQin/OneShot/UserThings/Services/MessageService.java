package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getUncheckMessage(int user_id);
    public List<Message> getHistoryMessage(int user_id,int pageNum);//要有偏移量，偏移量=上次uncheck message的数量，可作为实现类的成员变量
}