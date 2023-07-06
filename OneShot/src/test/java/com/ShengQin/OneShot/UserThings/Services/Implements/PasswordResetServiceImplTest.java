package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.PasswordResetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordResetServiceImplTest {
    @Autowired
    PasswordResetService passwordResetService;
    @Test
    public void resetPassword(){;
        passwordResetService.sendCaptchaToMailbox("3508627758@qq.com");
    }
    @Test
    void testVerifyCaptcha(){
        String captcha ="DF2QR6";
        if (passwordResetService.verifyCaptcha("3508627758@qq.com",captcha)){
            String newPassword = "hmh123456";
            passwordResetService.resetPassword("3508627758@qq.com",newPassword);
        }else System.out.println("错误的验证码");
    }
}