package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.ResetPasswordService;
import com.ShengQin.OneShot.Utils.ServiceResult;

public class ResetPasswordServiceImpl implements ResetPasswordService {
    @Override
    public ServiceResult sendCaptchaToMailbox(int user_id) {
        return null;
    }

    @Override
    public boolean verifyCaptcha(int user_id, String userEnteredCaptcha) {
        return false;
    }

    @Override
    public ServiceResult resetPassword(String newPassword) {
        return null;
    }
}
