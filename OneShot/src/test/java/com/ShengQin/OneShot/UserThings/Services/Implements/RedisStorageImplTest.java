package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.TemporaryDataStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisStorageImplTest {
    @Autowired
    @Qualifier("redisStorageImpl")
    TemporaryDataStoreService temporaryDataStoreService;

    @Test
    void put() {
        Integer length = 800;
        long expire_time = 1*60*1000;
        temporaryDataStoreService.put("length",length,expire_time);
        System.out.println(temporaryDataStoreService.get("length"));
    }

    @Test
    void get() {
    }
    @Test
    void testInstanceOf(){
        System.out.println(aa("sb"));
    }
    private boolean aa(Object obj){
        if (obj instanceof String) return true;
        else return false;
    }

}