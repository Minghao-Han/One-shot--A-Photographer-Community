package com.ShengQin.OneShot.UserThings.Services.SubMessageServices;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.ShotCommentMessageMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShotCommentMessageService extends AbstractSubMessageService{
    @Autowired
    ShotCommentMessageMapper shotCommentMessageMapper;
    @Autowired
    UserService userService;
    @Autowired
    ShotService shotService;
    @Override
    public Message getMessage(int references_id) {
        Map<String,Object> messageData = shotCommentMessageMapper.getMessage(references_id);
        int commentator_id = ((Long)messageData.get("commentator_id")).intValue();
        int shot_id = ((Long)messageData.get("shot_id")).intValue();
        int parent_id = ((Long)messageData.get("parent_id")).intValue();
        String commentator_username = userService.getUserName(commentator_id);
        String content = (String) messageData.get("content");
        String messageText;
        if (parent_id==0) {
            String shot_title = shotService.getShot(shot_id).getTitle();
            messageText = commentator_username + "评论了你的shot " + shot_title + ":\"" + content + "\"";
        }else {
            messageText = commentator_username + "评论了你的评论: \"" + content + "\"";
        }
        return new Message(messageText,messageData);
    }
}