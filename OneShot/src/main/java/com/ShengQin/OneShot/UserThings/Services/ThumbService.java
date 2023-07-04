package com.ShengQin.OneShot.UserThings.Services;

import java.util.List;

public interface ThumbService {
    public static final int success = 0;
    public static final int notExist = 1;
    public static final int operated = 2;
    public int shotGiveThumb(int thumber_id,int shot_id);
    public int shotRevokeThumb(int thumber_id,int shot_id);
    public boolean shotThumbExist(int thumber_id,int shot_id);
    public int getTotalThumbsOfUser(int user_id);//shot专用
    public int postGiveThumb(int thumber_id,int post_id);
    public int postRevokeThumb(int thumber_id,int post_id);
    public boolean postThumbExist(int thumber_id,int post_id);
}
