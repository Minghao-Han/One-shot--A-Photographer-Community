package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.PersonalPageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonalPageServiceImplTest {
    @Autowired
    PersonalPageService personalPageService;

    @Test
    void getUserInfo() {
        System.out.println(personalPageService.getUserInfo(4));
    }
}