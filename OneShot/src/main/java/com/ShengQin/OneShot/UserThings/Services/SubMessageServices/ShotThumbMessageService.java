package com.ShengQin.OneShot.UserThings.Services.SubMessageServices;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.ShotThumbMessageMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShotThumbMessageService extends AbstractSubMessageService {
    @Autowired
    ShotThumbMessageMapper shotThumbMessageMapper;
    @Autowired
    UserService userService;
    @Autowired
    ShotService shotService;

    @Override
    public Message getMessage(int references_id) {
        Map<String,Object> messageData = shotThumbMessageMapper.getMessage(references_id);
        int thumber_id = ((Long)messageData.get("thumber_id")).intValue();
        int shot_id = ((Long)messageData.get("shot_id")).intValue();
        String thumber_username = userService.getUserName(thumber_id);
        String shot_title = shotService.getShot(shot_id).getTitle();
        String messageText = thumber_username+"点赞了你的shot "+shot_title;
        return new Message(messageText,messageData);
    }
}
