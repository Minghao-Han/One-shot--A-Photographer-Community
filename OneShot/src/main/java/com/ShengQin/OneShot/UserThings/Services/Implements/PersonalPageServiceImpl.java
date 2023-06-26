package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Services.PersonalPageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonalPageServiceImpl implements PersonalPageService {
    @Override
    public Map<String, Object> getUserInfo(int user_id) {
        return null;
    }

    @Override
    public List<Shot> getUserShot(int user_id, int pageNum) {
        return null;
    }
}
