package com.ShengQin.OneShot.Utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CaptchaGenerator {//captcha:验证码
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int DEFAULT_CAPTCHA_LENGTH = 6;

    public String generate(int length) {
        Random random = new Random();
        StringBuilder captchaBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            captchaBuilder.append(randomChar);
        }
        return captchaBuilder.toString();
    }

    public String defaultGenerate(){
        return generate(DEFAULT_CAPTCHA_LENGTH);
    }
}
