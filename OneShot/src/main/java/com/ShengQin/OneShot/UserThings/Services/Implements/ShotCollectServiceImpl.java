package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.CollectMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShotCollectServiceImpl implements ShotCollectService {
    @Autowired
    ShotService shotService;
    @Autowired
    CollectMapper collectMapper;
    @Override
    public int collect(int collector_id, int shot_id) {
        if (!shotService.isExist(shot_id)) return notExist;
        else if (collectMapper.shotCollectionExist(collector_id,shot_id)) return operated;
        else {
            shotService.addCollect(shot_id);
            collectMapper.shotAddCollect(collector_id, shot_id);
            return success;
        }
    }

    @Override
    public int cancelCollect(int collector_id, int shot_id) {
        if (!shotService.isExist(shot_id)) return notExist;
        else if (!collectMapper.shotCollectionExist(collector_id,shot_id)) return operated;
        else {
            shotService.subCollect(shot_id);
            collectMapper.shotCancelCollect(collector_id, shot_id);
            return success;
        }
    }
}
