package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.VO.PersonalPageVO;
import com.ShengQin.OneShot.VO.ShotVO;

import java.util.List;

public interface PersonalPageService {
    public PersonalPageVO getUserInfo(int user_id);//获得User和该用户shot
    public List<ShotVO> getUserShot(int user_id, int pageNum);//获得该用户的其他shot，调用ShotService
    public List<User> getFans(int user_id, int pageNum);;
}
