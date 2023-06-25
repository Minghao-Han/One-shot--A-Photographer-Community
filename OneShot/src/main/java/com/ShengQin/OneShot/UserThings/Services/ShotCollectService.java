package com.ShengQin.OneShot.UserThings.Services;

public interface ShotCollectService {
    public boolean collect(int collector_id, int shot_id);
    public boolean CancelCollect(int collector_id,int shot_id);
}
