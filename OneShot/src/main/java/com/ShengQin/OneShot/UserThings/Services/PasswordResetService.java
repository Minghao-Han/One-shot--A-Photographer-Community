package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;

public interface PasswordResetService {
    public int DEFAULT_CAPTCHA_LENGTH=6;
    public long DEFAULT_CAPTCHA_EXPIRE_TIME=3*60*1000;
    public ServiceResult sendCaptchaToMailbox(String email);
    public boolean verifyCaptcha(String email,String userEnteredCaptcha);
    public ServiceResult resetPassword(String email,String newPassword);
}
