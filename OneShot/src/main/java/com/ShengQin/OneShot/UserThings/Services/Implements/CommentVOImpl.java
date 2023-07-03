package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Services.CommentVOService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentVOImpl implements CommentVOService {
    @Autowired
    UserService userService;
    @Override
    public CommentVO createCommentVO(Comment comment) {
        String commentatorUserName = userService.getUserName(comment.getCommentator_id());//发评论的人的用户名
        String receiverUserName = userService.getUserName(comment.getReceiver_id());//被评论的人的用户名
        CommentVO commentVO = new CommentVO(comment.getId(), comment.getInnerID(), comment.getShot_id(),comment.getReceiver_id(), comment.getCommentator_id(), comment.getTime(),comment.getContent(),commentatorUserName,receiverUserName);
        return commentVO;
    }
}
