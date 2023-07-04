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
        passwordResetService.sendCaptchaToMailbox(5);
    }
    @Test
    void testVerifyCaptcha(){
        String captcha ="GJIEOR";
        if (passwordResetService.verifyCaptcha(5,captcha)){
            String newPassword = "11223344hmh";
            passwordResetService.resetPassword(5,newPassword);
        }else System.out.println("错误的验证码");
    }
}