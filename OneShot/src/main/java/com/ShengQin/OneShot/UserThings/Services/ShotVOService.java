package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.VO.ShotVO;

public interface ShotVOService {
    public ShotVO createShotVO(Shot shot,int user_id);
}
