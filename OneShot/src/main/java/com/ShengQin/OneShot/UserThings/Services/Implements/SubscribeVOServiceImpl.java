package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Subscribe;
import com.ShengQin.OneShot.UserThings.Services.SubscribeVOService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.SubscribeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeVOServiceImpl implements SubscribeVOService {
    @Autowired
    UserService userService;
    @Override
    public SubscribeVO createSubscribeVO(Subscribe subscribe) {
        String subscribeName = userService.getUserName(subscribe.getSubscribedId());
        SubscribeVO subscribeVO = new SubscribeVO(subscribe.getId(), subscribe.getUserId(), subscribe.getSubscribedId(), subscribe.getTime(),subscribeName);
        return subscribeVO;
    }
}
