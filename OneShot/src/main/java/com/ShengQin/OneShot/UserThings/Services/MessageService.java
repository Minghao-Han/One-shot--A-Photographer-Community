package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.VO.ThumbCommentMessageVO;

import java.util.List;

public interface MessageService {
    public static final int COMMENT = 0;
    public static final int THUMB = 1;
    public static final int SHOT = 0;
    public static final int POST = 1;
    public List<Message> getUncheckMessages(int user_id);
    public List<ThumbCommentMessageVO> getHistoryMessage(int user_id, int pageNum);//要有偏移量，偏移量=上次uncheck message的数量，可作为实现类的成员变量
}
