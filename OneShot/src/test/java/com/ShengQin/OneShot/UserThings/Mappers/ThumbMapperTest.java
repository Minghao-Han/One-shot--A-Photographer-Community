package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Thumb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    void getTotalThumb() {
        List<Integer> ids = new ArrayList<>();
        ids.add(15);
        ids.add(9);
        int totalThumb = thumbMapper.getTotalThumb(ids);
        System.out.println(totalThumb);
    }
}