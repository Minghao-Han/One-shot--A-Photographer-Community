package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Shot;

import java.util.List;

public interface ShotBrowseService {
    public static final int PAGE_SIZE = 8;
    public List<Shot> getRecommendPage(int user_id, int pageNum);
}
