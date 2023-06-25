package com.ShengQin.OneShot.UserThings.Services;

public interface ThumbService {
    public boolean shotGiveThumb(int thumber_id,int shot_id);
    public boolean shotRevokeThumb(int thumber_id,int shot_id);
    public boolean postGiveThumb(int thumber_id,int post_id);
    public boolean postRevokeThumb(int thumber_id,int post_id);
}
