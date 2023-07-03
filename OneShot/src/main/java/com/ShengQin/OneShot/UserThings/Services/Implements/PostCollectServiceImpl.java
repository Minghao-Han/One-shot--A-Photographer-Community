package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.PostCollectService;
import org.springframework.stereotype.Service;

@Service
public class PostCollectServiceImpl implements PostCollectService {
    @Override
    public int collect(int collector_id, int post_id) {
        return operated;
    }

    @Override
    public int cancelCollect(int collector_id, int post_id) {
        return operated;
    }
}
