package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Mappers.AccountMapper;
import com.ShengQin.OneShot.UserThings.Services.*;
import com.ShengQin.OneShot.VO.PersonalPageVO;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalPageServiceImpl implements PersonalPageService {
    @Autowired
    UserService userService;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    SubscribeService subscribeService;
    @Autowired
    ThumbService thumbService;
    @Autowired
    ShotService shotService;
    @Autowired
    ShotVOService shotVOService;
    @Override
    public PersonalPageVO getUserInfo(int user_id) {
        User user = userService.getUser(user_id);
        PersonalPageVO personalPageVO = new PersonalPageVO(user);
        int totalReceivedThumbs = thumbService.getTotalThumbsOfUser(user_id);
        personalPageVO.setTotalReceivedThumbs(totalReceivedThumbs);
        int totalFancies = subscribeService.getFanciesNum(user_id);
        personalPageVO.setTotalFancies(totalFancies);
        String email = accountMapper.getEmail(user_id);
        personalPageVO.setEmail(email);
        return personalPageVO;
    }

    @Override
    public List<ShotVO> getUserShot(int user_id, int pageNum) {
        List<ShotVO> shotVOs = new ArrayList<>();
        List<Shot> shots = shotService.getShotsOfUser(user_id);
        for (Shot shot : shots) {
            shotVOs.add(shotVOService.createShotVO(shot,user_id));
        }
        return shotVOs;
    }

    @Override
    public List<User> getFans(int user_id, int pageNum) {
        List<Integer> fansId = subscribeService.getFansId(user_id,pageNum);
        List<User> fans = new ArrayList<>();
        for (Integer fanId:fansId) {
            fans.add(userService.getUser(fanId));
        }
        return fans;
    }
}
