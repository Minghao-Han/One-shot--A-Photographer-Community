package com.ShengQin.OneShot.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MailUtilTest {
    @Autowired
    MailUtil mailUtil;

    @Test
    void sendEmailCode() {
        mailUtil.sendEmailCode("testCode","3508627758@qq.com","3508627758@qq.com","验证码更改邮箱");
    }
}