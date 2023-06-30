package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Shot;

import java.util.List;
import java.util.Map;

public interface PersonalPageService {
    public Map<String,Object> getUserInfo(int user_id);//获得User和该用户shot
    public List<Shot> getUserShot(int user_id,int pageNum);//获得该用户的其他shot，调用ShotService
}
