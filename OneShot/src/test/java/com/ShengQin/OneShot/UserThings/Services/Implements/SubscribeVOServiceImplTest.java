package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Subscribe;
import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import com.ShengQin.OneShot.UserThings.Services.SubscribeVOService;
import com.ShengQin.OneShot.VO.SubscribeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SubscribeVOServiceImplTest {
    @Autowired
    SubscribeVOService subscribeVOService;
    @Autowired
    SubscribeService subscribeService;

    @Test
    void createSubscribeVO() {
        List<SubscribeVO> subscribes = subscribeService.getSubscribes(4,1);
        System.out.println(subscribes);
    }
}