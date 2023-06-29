package com.ShengQin.OneShot.UserThings.Services.SubMessageServices;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.PostCommentMessageMapper;
import com.ShengQin.OneShot.UserThings.Services.PostService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PostCommentMessageService extends AbstractSubMessageService{
    @Autowired
    UserService userService;
    @Autowired
    PostCommentMessageMapper postCommentMessageMapper;
    @Autowired
    PostService postService;

    @Override
    public Message getMessage(int references_id) {
        Map<String,Object> messageData = postCommentMessageMapper.getMessage(references_id);
        int commentator_id = ((Long)messageData.get("commentator_id")).intValue();
        int post_id = ((Long)messageData.get("post_id")).intValue();
        String commentator_username = userService.getUserName(commentator_id);
        String post_title = postService.getPost(post_id).getTitle();
        String content = (String) messageData.get("content");
        String messageText = commentator_username+"评论了你的post "+post_title+":\""+content+"\"";
        return new Message(messageText,messageData);
    }
}
