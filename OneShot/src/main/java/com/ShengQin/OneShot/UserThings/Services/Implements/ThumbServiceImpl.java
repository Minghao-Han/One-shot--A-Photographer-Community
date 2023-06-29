package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.MessageMapper;
import com.ShengQin.OneShot.UserThings.Mappers.ThumbMapper;
import com.ShengQin.OneShot.UserThings.Services.PostService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThumbServiceImpl implements ThumbService {
    @Autowired
    ShotService shotService;
    @Autowired
    PostService postService;
    @Autowired
    ThumbMapper thumbMapper;
    @Autowired
    MessageMapper messageMapper;

    @Override
    public int shotGiveThumb(int thumber_id, int shot_id) {
        if (!shotService.isExist(shot_id)) return notExist;
        else if (thumbMapper.shotThumbExist(thumber_id,shot_id)) {
            return operated;
        } else {
            shotService.addThumb(shot_id);//shot表里加点赞
            thumbMapper.shotAddThumb(thumber_id, shot_id);//往thumb_of_shot里加数据

            return success;
        }
    }

    @Override
    public int shotRevokeThumb(int thumber_id, int shot_id) {
        if (!shotService.isExist(shot_id)) return notExist;
        else if (!thumbMapper.shotThumbExist(thumber_id,shot_id)) {
            return operated;
        }
        else {
            shotService.subThumb(shot_id);
            thumbMapper.shotCancelThumb(thumber_id, shot_id);
            return success;
        }
    }

    @Override
    public int postGiveThumb(int thumber_id, int post_id) {
        if (!postService.isExist(post_id)) return notExist;
        else if (thumbMapper.postThumbExist(thumber_id,post_id)) {
            return operated;
        }else {
            postService.addThumb(post_id);
            thumbMapper.postAddThumb(thumber_id, post_id);
            return success;
        }
    }

    @Override
    public int postRevokeThumb(int thumber_id, int post_id) {
        if (!postService.isExist(post_id)) return notExist;
        else if (!thumbMapper.postThumbExist(thumber_id,post_id)) {
            return operated;
        }else {
            postService.subThumb(post_id);
            thumbMapper.postCancelThumb(thumber_id, post_id);
            return success;
        }
    }
}
