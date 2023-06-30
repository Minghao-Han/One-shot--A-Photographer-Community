package com.ShengQin.OneShot.UserThings.Services;


import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.ShotVO;

import java.util.List;

public interface ShotBrowseService {
    public static final int PAGE_SIZE = 8;
    public List<ShotVO> getRecommendPage(int user_id, int pageNum);
    public ServiceResult addPageView(int shot_id);
}
