package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Subscribe;
import com.ShengQin.OneShot.UserThings.Mappers.SubscribeMapper;
import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import com.ShengQin.OneShot.UserThings.Services.SubscribeVOService;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.SubscribeVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    SubscribeMapper subscribeMapper;
    @Autowired
    UserExistService userExistService;
    @Autowired
    SubscribeVOService subscribeVOService;
    @Override
    public List<SubscribeVO> getSubscribes(int user_id, int pageNum) {
        List<SubscribeVO> subscribeVOs = new ArrayList<>();
        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<Subscribe> subscriptions = subscribeMapper.getSubscription(user_id);
        for (Subscribe subscribe : subscriptions) {
            subscribeVOs.add(subscribeVOService.createSubscribeVO(subscribe));
        }
        return subscribeVOs;
    }

    @Override
    public ServiceResult subscribe(int user_id, int subscribed_id) {
        if (!userExistService.userExist(subscribed_id)) return ServiceResult.NONEXISTENT;
        else if (subscribeMapper.isExist(user_id, subscribed_id)) return ServiceResult.OPERATED;
        else{
            subscribeMapper.subscribe(user_id, subscribed_id);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public ServiceResult cancelSubscribe(int user_id, int subscribed_id) {
        if (!subscribeMapper.isExist(user_id, subscribed_id)) return ServiceResult.OPERATED;
        else{
            subscribeMapper.cancelSubscribe(user_id, subscribed_id);
            return ServiceResult.SUCCESS;
        }
    }
}
