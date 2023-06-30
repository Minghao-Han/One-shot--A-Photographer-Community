package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.VO.CommentVO;

import java.util.List;

public interface CommentService {
    public static final int PAGE_SIZE = 6;
    public boolean createComment(int shotOrPost_id, int parent_id, int commentator_id, String content,int receiver_id);//在这个函数中生成id
    public List<CommentVO> getComments(int shotOrPost_id, int pageNum);
    public boolean deleteComment(int comment_id,int shotOrPost_id);
}
