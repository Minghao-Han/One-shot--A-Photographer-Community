package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Services.CommentService;
import com.ShengQin.OneShot.VO.CommentVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostCommentServiceImpl implements CommentService {

    @Override
    public boolean createComment(int shot_id, int parent_id, int commentator_id, String content, int receiver_id) {
        return false;
    }

    @Override
    public List<CommentVO> getComments(int shot_id, int pageNum) {
        return null;
    }

    @Override
    public boolean deleteComment(int comment_id, int shot_id) {
        return false;
    }
}
