package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Mappers.CollectMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.ShotVOService;
import com.ShengQin.OneShot.VO.ShotVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShotCollectServiceImpl implements ShotCollectService {
    @Autowired
    ShotService shotService;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ShotVOService shotVOService;
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

    @Override
    public List<ShotVO> getUserShotCollections(int user_id, int pageNum) {
        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<Integer> shot_ids = collectMapper.getCollectedShotId(user_id);
        List<ShotVO> shotVOs = new ArrayList<ShotVO>();
        for (int shot_id :
                shot_ids) {
            Shot shot = shotService.getShot(shot_id);
            shotVOs.add(shotVOService.createShotVO(shot,user_id));
        }
         return shotVOs;
    }

    @Override
    public boolean collectExist(int user_id, int shot_id) {
        return collectMapper.shotCollectionExist(user_id,shot_id);
    }
}
