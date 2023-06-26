package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Override
    public List<Map<String, String>> getSubscribes(int user_id, int pageNum) {
        return null;
    }

    @Override
    public void subscribe(int user_id, int subscribed_id) {

    }

    @Override
    public void cancelSubscribe(int user_id, int subscribed_id) {

    }
}
