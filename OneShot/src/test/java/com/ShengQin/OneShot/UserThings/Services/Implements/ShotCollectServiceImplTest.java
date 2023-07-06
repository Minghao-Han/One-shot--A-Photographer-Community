package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShotCollectServiceImplTest {
    @Autowired
    ShotCollectService shotCollectService;

    @Test
    void getUserShotCollections() {
        System.out.println(shotCollectService.getUserShotCollections(4,1));
    }
}