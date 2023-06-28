package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.UserThings.Services.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public List<Message> getUncheckMessage(int user_id) {
        return null;
    }

    @Override
    public List<Message> getHistoryMessage(int user_id, int pageNum) {
        return null;
    }
}
