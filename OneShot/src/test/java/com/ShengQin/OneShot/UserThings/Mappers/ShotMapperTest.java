package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Shot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShotMapperTest {
    @Autowired
    ShotMapper shotMapper;

    @Test
    void testGetId() {
    }

    @Test
    void getShotMatchesPreferenceHighTotal() {
    }

    @Test
    void getShotMatchesPreferenceHigh() {
        List<String> tags = new ArrayList<String>();
        tags.add("风光");
        tags.add("足球");
        tags.add("街拍");
        tags.add("人像");
        tags.add("美女");
        tags.add("黑白");
        List<Shot> shots = shotMapper.getShotMatchesPreferenceHigh(tags);
        for (Shot shot :
                shots) {
            System.out.println(shot);
        }
        System.out.println("finish");
    }

    @Test
    void getShotMatchesPreferenceLow() {
        List<String> tags = new ArrayList<String>();
        tags.add("风光");
        tags.add("足球");
        tags.add("街拍");
        tags.add("人像");
        tags.add("美女");
        tags.add("黑白");
        List<Shot> shots = shotMapper.getShotMatchesPreferenceLow(tags);
        for (Shot shot :
                shots) {
            System.out.println(shot);
        }
        System.out.println("finish");
    }

    @Test
    void getShotIgnoresPreferenceHighTotal() {
    }

    @Test
    void getShotIgnorePreferenceHigh() {
    }

    @Test
    void getShotIgnorePreferenceLow() {
    }

    @Test
    void testGetShotMatchesPreferenceHighTotal() {
    }

    @Test
    void testGetShotMatchesPreferenceHigh() {
    }

    @Test
    void testGetShotMatchesPreferenceLow() {
    }

    @Test
    void testGetShotIgnoresPreferenceHighTotal() {
    }

    @Test
    void testGetShotIgnorePreferenceHigh() {
    }

    @Test
    void testGetShotIgnorePreferenceLow() {
    }
}