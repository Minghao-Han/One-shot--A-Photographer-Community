package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.SubscribeVO;

import java.util.List;

public interface SubscribeService {
    public static final int PAGE_SIZE = 15;
    public List<SubscribeVO> getSubscribes(int user_id, int pageNum);
    public ServiceResult subscribe(int user_id, int subscribed_id);
    public ServiceResult cancelSubscribe(int user_id, int subscribed_id);
    public List<Integer> getFansId(int user_id, int pageNum);
    public int getFanciesNum(int user_id);
}
