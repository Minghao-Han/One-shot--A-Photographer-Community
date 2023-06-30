package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Thumb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThumbMapperTest {
    @Autowired
    ThumbMapper thumbMapper;

    @Test
    void shotAddThumb() {
        Thumb newThumb = new Thumb(4,12);
        int result = thumbMapper.shotAddThumb(newThumb);
        System.out.println(newThumb.getId());
    }
}