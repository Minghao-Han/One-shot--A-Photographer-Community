package com.ShengQin.OneShot.UserThings.Services.Implements;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CacheStorageImplTest {
    @Autowired
    CacheStorageImpl cacheStorage;

    @Test
    void put() throws InterruptedException {
        long expire_time = 3*60*1000;
        cacheStorage.put("fhy","is sb",expire_time);
        Thread.sleep(expire_time+2);
        String testStr = (String) cacheStorage.get("fhy");
        System.out.println(testStr);
    }

    @Test
    void get() {
    }
}