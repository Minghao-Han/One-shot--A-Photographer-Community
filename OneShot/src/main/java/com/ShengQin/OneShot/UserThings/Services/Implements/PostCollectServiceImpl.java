package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.PostCollectService;
import org.springframework.stereotype.Service;

@Service
public class PostCollectServiceImpl implements PostCollectService {
    @Override
    public boolean collect(int collector_id, int post_id) {
        return false;
    }

    @Override
    public boolean CancelCollect(int collector_id, int post_id) {
        return false;
    }
}
