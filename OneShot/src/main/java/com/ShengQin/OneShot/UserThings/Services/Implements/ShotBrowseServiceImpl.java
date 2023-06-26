package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Services.ShotBrowseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShotBrowseServiceImpl implements ShotBrowseService {
    @Override
    public List<Shot> getRecommendPage(int user_id, int pageNum) {
        return null;
    }
}
