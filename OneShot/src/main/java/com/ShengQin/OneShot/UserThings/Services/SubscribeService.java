package com.ShengQin.OneShot.UserThings.Services;

import java.util.List;
import java.util.Map;

public interface SubscribeService {
    public List<Map<String,String>> getSubscribes(int user_id, int pageNum);
    public void subscribe(int user_id, int subscribed_id);
    public void cancelSubscribe(int user_id, int subscribed_id);
}
