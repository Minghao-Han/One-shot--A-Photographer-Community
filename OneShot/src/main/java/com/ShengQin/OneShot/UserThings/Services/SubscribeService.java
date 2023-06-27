package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;

import java.util.List;
import java.util.Map;

public interface SubscribeService {
    public List<Map<String,String>> getSubscribes(int user_id, int pageNum);
    public ServiceResult subscribe(int user_id, int subscribed_id);
    public ServiceResult cancelSubscribe(int user_id, int subscribed_id);
}
