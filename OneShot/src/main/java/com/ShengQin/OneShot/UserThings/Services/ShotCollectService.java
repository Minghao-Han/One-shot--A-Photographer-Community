package com.ShengQin.OneShot.UserThings.Services;

public interface ShotCollectService {
    public static final int success=0;
    public static final int notExist=1;
    public static final int operated=2;
    public int collect(int collector_id, int shot_id);
    public int cancelCollect(int collector_id, int shot_id);
}
