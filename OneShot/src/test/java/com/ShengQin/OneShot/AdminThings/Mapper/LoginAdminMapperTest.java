package com.ShengQin.OneShot.AdminThings.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginAdminMapperTest {

    @Autowired
    LoginAdminMapper loginAdminMapper;
    @Test
    void getPassword() {
        System.out.println(loginAdminMapper.getId("whu@qq.com"));
    }

    @Test
    void getId() {
        System.out.println(loginAdminMapper.getPassword("whu@qq.com"));
    }
}