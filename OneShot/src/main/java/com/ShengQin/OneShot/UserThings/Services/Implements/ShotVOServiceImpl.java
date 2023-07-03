package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Services.ShotVOService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShotVOServiceImpl implements ShotVOService {
    @Autowired
    UserService userService;
    @Override
    public ShotVO createShotVO(Shot shot) {
        String user_name = userService.getUserName(shot.getUser_id());
        ShotVO newShotVO = new ShotVO(shot.getId(), shot.getUser_id(),user_name, shot.getTitle(), shot.getContent(), shot.getTotal_thumb(), shot.getTotal_collect(), shot.getPageView(), shot.getCreateTime());
        return newShotVO;
    }
}
