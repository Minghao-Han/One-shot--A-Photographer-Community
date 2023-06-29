package com.ShengQin.OneShot.UserThings.Services.SubMessageServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShotCommentMessageServiceTest {

    @Autowired
    ShotCommentMessageService shotCommentMessageService;

    @Test
    void getMessages() {
        System.out.println(shotCommentMessageService.getMessage(11));
    }
}