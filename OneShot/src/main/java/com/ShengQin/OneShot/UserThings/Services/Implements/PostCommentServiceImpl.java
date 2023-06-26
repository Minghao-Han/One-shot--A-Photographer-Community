package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Services.PostCommentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    @Override
    public boolean createComment(int post_id, int parent_id, int commentator_id, Date time, String content) {
        return false;
    }

    @Override
    public List<Comment> getComments(int post_id, int pageNum) {
        return null;
    }

    @Override
    public boolean deleteComment(int comment_id, int post_id) {
        return false;
    }
}
