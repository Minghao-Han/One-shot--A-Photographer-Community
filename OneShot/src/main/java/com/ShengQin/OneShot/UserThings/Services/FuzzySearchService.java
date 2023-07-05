package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.VO.ShotVO;

import java.util.List;

public interface FuzzySearchService {
    public List<ShotVO> search(String searchContent,int user_id);
}
