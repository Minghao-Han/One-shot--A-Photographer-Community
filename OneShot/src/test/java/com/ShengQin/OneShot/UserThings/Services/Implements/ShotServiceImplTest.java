package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.ShotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShotServiceImplTest {
    @Autowired
    ShotService shotService;

    @Test
    void createShot() {
        int user_id = 4;
        String title = "ylq钓鱼照";
        String content = "YLQ诚邀你共进晚餐";
        Date time = new Date(System.currentTimeMillis());
        List<String> tags = new ArrayList<String>();
        tags.add("帅");
        tags.add("钓鱼");
        tags.add("武汉大学");
        tags.add("185黑皮");
        tags.add("体育生");
        shotService.createShot(user_id,title,content,time,tags);
    }

    @Test
    void addThumb() {
        shotService.addThumb(8);
    }

    @Test
    void delete() {
        shotService.delete(7);
    }
}