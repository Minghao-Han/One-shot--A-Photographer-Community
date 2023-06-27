package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Mappers.ShotCommentMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotCommentService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShotCommentServiceImpl implements ShotCommentService {
    @Autowired
    ShotCommentMapper shotCommentMapper;
    @Autowired
    ShotService shotService;
    @Override
    public boolean createComment(int shot_id, int parent_id, int commentator_id, String content) {
        if (!shotService.isExist(shot_id)) return false;
        else {
            int innerID = shotCommentMapper.getNewInnerID(shot_id);//获取该评论在这条shot中的id，即innerID
            shotCommentMapper.insert(new Comment(innerID,shot_id,parent_id,commentator_id,content));
            return true;
        }
    }

    @Override
    public List<Comment> getComments(int shot_id, int pageNum) {
        return null;
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
