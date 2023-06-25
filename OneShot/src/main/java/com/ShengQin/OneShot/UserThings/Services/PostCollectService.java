package com.ShengQin.OneShot.UserThings.Services;

public interface PostCollectService {
    public boolean collect(int collector_id,int post_id);
    public boolean CancelCollect(int collector_id,int post_id);
}
