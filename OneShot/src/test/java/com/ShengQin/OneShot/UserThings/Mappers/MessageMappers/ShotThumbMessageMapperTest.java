package com.ShengQin.OneShot.UserThings.Mappers.MessageMappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShotThumbMessageMapperTest {
    @Autowired
    ShotThumbMessageMapper shotThumbMessageMapper;

    @Test
    void getMessage() {
        Map<String,Object> msg = shotThumbMessageMapper.getMessage(2);
        System.out.println(msg);
    }
}