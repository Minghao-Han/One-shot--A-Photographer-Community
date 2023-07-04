package com.ShengQin.OneShot.Utils;

import com.ShengQin.OneShot.UserThings.Mappers.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringContextUtilTest {

    @Test
    void getBean() {
        UserMapper userMapper = (UserMapper) SpringContextUtil.getBean("userMapper");
        System.out.println(userMapper.getUserName(4));
    }
}