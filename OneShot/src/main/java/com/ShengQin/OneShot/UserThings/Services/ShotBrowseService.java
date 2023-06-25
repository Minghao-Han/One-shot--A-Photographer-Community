package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Shot;

import java.util.List;

public interface ShotBrowseService {
    public List<Shot> getRecommendPage(int user_id, int pageNum);
}
