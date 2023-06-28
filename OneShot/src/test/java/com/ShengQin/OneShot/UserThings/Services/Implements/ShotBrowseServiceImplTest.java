package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Services.ShotBrowseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShotBrowseServiceImplTest {
    @Autowired
    ShotBrowseService shotBrowseService;

    @Test
    void getRecommendPage() {
        List<Shot> shots = shotBrowseService.getRecommendPage(4,2);
        for (Shot shot : shots) {
            System.out.println(shot);
        }
    }
}