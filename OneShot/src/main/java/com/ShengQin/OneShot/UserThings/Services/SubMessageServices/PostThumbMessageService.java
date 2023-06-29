package com.ShengQin.OneShot.UserThings.Services.SubMessageServices;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.PostThumbMessageMapper;
import com.ShengQin.OneShot.UserThings.Services.PostService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PostThumbMessageService extends AbstractSubMessageService{
    @Autowired
    PostThumbMessageMapper postThumbMessageMapper;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @Override
    public Message getMessage(int references_id) {
        Map<String,Object> messageData = postThumbMessageMapper.getMessage(references_id);
        int thumber_id = ((Long)messageData.get("thumber_id")).intValue();
        int post_id = ((Long)messageData.get("post_id")).intValue();
        String thumber_username = userService.getUserName(thumber_id);
        String post_title = postService.getPost(post_id).getTitle();
        String messageText = thumber_username+"点赞了你的post "+post_title;
        return new Message(messageText,messageData);
    }
}
