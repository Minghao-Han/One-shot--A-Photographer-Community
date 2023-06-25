package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Comment;

import java.util.Date;
import java.util.List;

public interface ShotCommentService {
    public boolean createComment(int shot_id, int parent_id, int commentator_id, Date time, String content);//在这个函数中生成id
    public List<Comment> getComments(int shot_id,int pageNum);
    public boolean deleteComment(int comment_id,int shot_id);
}
