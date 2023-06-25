package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.CollectMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShotCollectServiceImpl implements ShotCollectService {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public boolean collect(int collector_id, int shot_id) {
        return false;
    }

    @Override
    public boolean CancelCollect(int collector_id, int shot_id) {
        return false;
    }
}
