package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Shot;

import java.util.Date;
import java.util.List;

public interface ShotService {
    public Shot getShot(int shot_id);
    public default void saveShot(Shot shot){
        if (isExist(shot)) update(shot);
        else insert(shot);
    }
    public boolean isExist(Shot shot);
    public boolean isExist(int shot_id);
    public void insert(Shot newShot);
    public void update(Shot updatedShot);
    public void delete(int shot_id);

    public void createShot(String title, String content, Date time, List<String> tags);
    public void addThumb(Shot shot);
    public void addCollect(Shot shot);
}
