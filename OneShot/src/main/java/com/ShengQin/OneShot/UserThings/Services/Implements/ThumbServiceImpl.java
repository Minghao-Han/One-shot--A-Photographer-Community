package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.ThumbService;
import org.springframework.stereotype.Service;

@Service
public class ThumbServiceImpl implements ThumbService {
    @Override
    public boolean shotGiveThumb(int thumber_id, int shot_id) {
        return false;
    }

    @Override
    public boolean shotRevokeThumb(int thumber_id, int shot_id) {
        return false;
    }

    @Override
    public boolean postGiveThumb(int thumber_id, int post_id) {
        return false;
    }

    @Override
    public boolean postRevokeThumb(int thumber_id, int post_id) {
        return false;
    }
}
