package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Subscribe;
import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubscribeServiceImplTest {
    @Autowired
    SubscribeService subscribeService;

    @Test
    void getSubscribes() {

    }

    @Test
    void getSubscriptionNum() {
        System.out.println(subscribeService.getSubscriptionNum(110));
    }
}