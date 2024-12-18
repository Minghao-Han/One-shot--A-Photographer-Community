package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Services.*;
import com.ShengQin.OneShot.VO.CommentVO;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShotDetailServiceImpl implements ShotDetailService {
    @Autowired
    ShotService shotService;
    @Autowired
    ShotVOService shotVOService;
    @Autowired
    @Qualifier("shotCommentServiceImpl")
    CommentService shotCommentServiceImpl;

    @Override
    public Map<String, Object> getShotDetail(int shot_id,int user_id) {
        Map<String, Object> shotWithFewComments = new HashMap<>();
        Shot shot = shotService.getShot(shot_id);
        ShotVO shotVO = shotVOService.createShotVO(shot,user_id);
        shotWithFewComments.put("shotVO",shotVO);
        List<CommentVO> commentVOs = shotCommentServiceImpl.getComments(shot_id,1);
        shotWithFewComments.put("commentVOs",commentVOs);
        return shotWithFewComments;
    }
}
