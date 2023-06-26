package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Services.ShotCommentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShotCommentServiceImpl implements ShotCommentService {
    @Override
    public boolean createComment(int shot_id, int parent_id, int commentator_id, Date time, String content) {
        return false;
    }

    @Override
    public List<Comment> getComments(int shot_id, int pageNum) {
        return null;
    }

    @Override
    public boolean deleteComment(int comment_id, int shot_id) {
        return false;
    }
}
