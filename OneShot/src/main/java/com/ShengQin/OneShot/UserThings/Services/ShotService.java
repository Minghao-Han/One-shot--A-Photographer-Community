package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Shot;

import java.util.Date;
import java.util.List;

public interface ShotService {
    public List<Shot> getAllShots();
    public Shot getShot(int shot_id);
    public List<Shot> getShotsOfUser(int user_id);
    public boolean isExist(Shot shot);
    public boolean isExist(int shot_id);
    public void save(Shot shot);
    public void delete(int shot_id);

    public Integer createShot(int user_id, String title, String content, Date time, List<String> tags);
    public void addThumb(int shot_id);
    public void addCollect(int shot_id);
    public void addPageView(int shot_id);
    public void subThumb(int shot_id);
    public void subCollect(int shot_id);
}
