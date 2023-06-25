package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Comment;

import java.util.Date;
import java.util.List;

public interface PostCommentService {
    public boolean createComment(int post_id, int parent_id, int commentator_id, Date time, String content);//service中要生成id
    public List<Comment> getComments(int post_id, int pageNum);
    public boolean deleteComment(int comment_id,int post_id);
}
