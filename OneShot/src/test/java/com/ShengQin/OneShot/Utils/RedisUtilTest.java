package com.ShengQin.OneShot.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RedisUtilTest {
    @Autowired
    RedisUtil redisUtil;

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void testSet() {
    }

    @Test
    void getAndSet() {
    }

    @Test
    void delete() {
    }

    @Test
    void deserializeObject() {
    }

    @Test
    void serializeObject() {
    }
    @Test
    void testSerialize(){
        String value = "6379";
        String serializeValue = redisUtil.serializeObject(value);
        Object deserializeValue = redisUtil.deserializeObject(serializeValue);
        System.out.println(deserializeValue instanceof String);
    }
}