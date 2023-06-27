package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.SubscribeMapper;
import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import com.ShengQin.OneShot.Utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    SubscribeMapper subscribeMapper;
    @Autowired
    UserExistService userExistService;
    @Override
    public List<Map<String, String>> getSubscribes(int user_id, int pageNum) {
        return null;
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
