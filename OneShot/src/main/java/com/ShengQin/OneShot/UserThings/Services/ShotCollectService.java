package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.VO.ShotVO;

import java.util.List;

public interface ShotCollectService {
    public static final int success=0;
    public static final int notExist=1;
    public static final int operated=2;
    public static final int PAGE_SIZE=6;
    public int collect(int collector_id, int shot_id);
    public int cancelCollect(int collector_id, int shot_id);
    public List<ShotVO> getUserShotCollections(int user_id,int pageNum);
}
