package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Mappers.ShotCommentMapper;
import com.ShengQin.OneShot.UserThings.Services.CommentVOService;
import com.ShengQin.OneShot.UserThings.Services.ShotCommentService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.VO.CommentVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShotCommentServiceImpl implements ShotCommentService {
    @Autowired
    ShotCommentMapper shotCommentMapper;
    @Autowired
    ShotService shotService;
    @Autowired
    CommentVOService commentVOService;
    @Override
    public boolean createComment(int shot_id, int parent_id, int commentator_id, String content,int receiver_id) {
        if (!shotService.isExist(shot_id)) return false;
        else {
            Integer innerID = shotCommentMapper.getNewInnerID(shot_id);//获取该评论在这条shot中的id，即innerID
            if (innerID==null) innerID=1;
            shotCommentMapper.insert(new Comment((int)innerID,shot_id,parent_id,commentator_id,content,receiver_id));
            return true;
        }
    }

    @Override
    public List<CommentVO> getComments(int shot_id, int pageNum) {
        List<CommentVO> commentVOs = new ArrayList<>();
        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<Comment> comments = shotCommentMapper.getComment(shot_id);
        for (Comment comment:comments) {
            commentVOs.add(commentVOService.createCommentVO(comment));
        }
        return commentVOs;
    }

    @Override
    public boolean deleteComment(int innerID, int shot_id) {
        if (!shotCommentMapper.isExist(shot_id,innerID)) return false;
        else {
            shotCommentMapper.delete(shot_id,innerID);
            return true;
        }
    }
}
