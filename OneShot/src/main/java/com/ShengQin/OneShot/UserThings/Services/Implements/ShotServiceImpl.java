package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Mappers.ShotMapper;
import com.ShengQin.OneShot.UserThings.Mappers.TagMapper;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShotServiceImpl implements ShotService {
    @Autowired
    ShotMapper shotMapper;
    @Autowired
    TagMapper tagMapper;

    @Override
    public Shot getShot(int shot_id) {
        return null;
    }

    @Override
    public boolean isExist(Shot shot) {
        return false;
    }

    @Override
    public boolean isExist(int shot_id) {
        return false;
    }

    @Override
    public void insert(Shot newShot) {

    }

    @Override
    public void update(Shot updatedShot) {

    }

    @Override
    public void delete(int shot_id) {

    }

    @Override
    public void createShot(int creator_id, String title, String content, Date time, List<String> tags) {
        int shot_id = shotMapper.insert(new Shot(creator_id,title,content,time));
        tagMapper.addTagsToShot(tags,shot_id);
    }

    @Override
    public void addThumb(int shot_id) {
        Shot shot = shotMapper.getShot(shot_id);
        System.out.println(shot);
        shot.addThumb();
        System.out.println(shot);
        shotMapper.save(shot);
    }

    @Override
    public void addCollect(int shot_id) {
        Shot shot = shotMapper.getShot(shot_id);
        shot.addCollect();
        shotMapper.save(shot);
    }
}
