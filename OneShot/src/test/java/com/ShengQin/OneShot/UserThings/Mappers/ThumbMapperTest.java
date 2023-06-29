package com.ShengQin.OneShot.UserThings.Mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThumbMapperTest {
    @Autowired
    ThumbMapper thumbMapper;

    @Test
    void shotAddThumb1() {
        int result = (thumbMapper.shotAddThumb1(5,12)).intValue();
        System.out.println("result is "+result);
    }
}