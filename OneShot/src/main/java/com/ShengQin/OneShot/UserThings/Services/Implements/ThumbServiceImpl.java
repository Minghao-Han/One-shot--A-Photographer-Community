package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.Entities.Thumb;
import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.MessageMapper;
import com.ShengQin.OneShot.UserThings.Mappers.ThumbMapper;
import com.ShengQin.OneShot.UserThings.Services.PostService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            Thumb newThumb = new Thumb(thumber_id, shot_id);
            thumbMapper.shotAddThumb(newThumb);//往thumb_of_shot里加数据
            int receiver_id = shotService.getShot(shot_id).getUser_id();
            messageMapper.createMessage("thumb_of_shot", newThumb.getId(), receiver_id);
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
            int references_id = thumbMapper.shotCancelThumb(thumber_id, shot_id);
            messageMapper.deleteMessage("thumb_of_shot",references_id);
            return success;
        }
    }

    @Override
    public boolean shotThumbExist(int thumber_id, int shot_id) {
        return thumbMapper.shotThumbExist(thumber_id,shot_id);
    }

    @Override
    public int getTotalThumbsOfUser(int user_id) {
        List<Shot> shots = shotService.getShotsOfUser(user_id);
        if (shots==null) return 0;
        List<Integer> shot_ids = new ArrayList<>();
        for (Shot shot:shots) {
            shot_ids.add(shot.getId());
        }
        return thumbMapper.getTotalThumb(shot_ids);
    }


    @Override
    public int postGiveThumb(int thumber_id, int post_id) {
        if (!postService.isExist(post_id)) return notExist;
        else if (thumbMapper.postThumbExist(thumber_id,post_id)) {
            return operated;
        }else {
            postService.addThumb(post_id);
            Thumb newThumb = new Thumb(thumber_id, post_id);
            thumbMapper.postAddThumb(newThumb);//往thumb_of_shot里加数据
            int receiver_id = postService.getPost(post_id).getUserId();
            messageMapper.createMessage("thumb_of_post", newThumb.getId(), receiver_id);
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
            int references_id = thumbMapper.postCancelThumb(thumber_id, post_id);
            messageMapper.deleteMessage("thumb_of_post",references_id);
            return success;
        }
    }

    @Override
    public boolean postThumbExist(int thumber_id, int post_id) {
        return thumbMapper.postThumbExist(thumber_id,post_id);
    }
}
