package com.ShengQin.OneShot.UserThings.Mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscribeMapperTest {
    @Autowired
    SubscribeMapper subscribeMapper;

    @Test
    void getFanciesId() {
        System.out.println(subscribeMapper.getFansId(5));
    }
}