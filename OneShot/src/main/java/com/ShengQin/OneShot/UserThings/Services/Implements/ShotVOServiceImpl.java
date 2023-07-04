package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Mappers.CollectMapper;
import com.ShengQin.OneShot.UserThings.Mappers.ThumbMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import com.ShengQin.OneShot.UserThings.Services.ShotVOService;
import com.ShengQin.OneShot.UserThings.Services.ThumbService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShotVOServiceImpl implements ShotVOService {
    @Autowired
    UserService userService;
    @Autowired
    ThumbMapper thumbMapper;
    @Autowired
    CollectMapper collectMapper;
    @Override
    public ShotVO createShotVO(Shot shot,int user_id) {
        String user_name = userService.getUserName(shot.getUser_id());
        boolean thumbed = thumbMapper.shotThumbExist(user_id, shot.getId());
        boolean collected = collectMapper.shotCollectionExist(user_id, shot.getId());
        ShotVO newShotVO = new ShotVO(shot.getId(), shot.getUser_id(),user_name, shot.getTitle(), shot.getContent(), shot.getTotal_thumb(), shot.getTotal_collect(), shot.getPageView(), shot.getCreateTime(),thumbed,collected);
        return newShotVO;
    }
}
