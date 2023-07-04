package com.ShengQin.OneShot.UserThings.Mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoginLogMapperTest {
    @Autowired
    LoginLogMapper loginLogMapper;
    @Test
    void log() {
        loginLogMapper.log(1,"登录","127.0.0.1","Mac OS","safari",new Date(),null);
    }
}