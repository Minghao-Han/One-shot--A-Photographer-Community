package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;

public interface ResetPasswordService {
    public ServiceResult sendCaptchaToMailbox(int user_id);
    public boolean verifyCaptcha(int user_id,String userEnteredCaptcha);
    public ServiceResult resetPassword(String newPassword);
}
