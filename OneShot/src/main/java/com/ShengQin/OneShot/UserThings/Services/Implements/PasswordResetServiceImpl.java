package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Account;
import com.ShengQin.OneShot.UserThings.Mappers.AccountMapper;
import com.ShengQin.OneShot.UserThings.Services.PasswordResetService;
import com.ShengQin.OneShot.UserThings.Services.TemporaryDataStoreService;
import com.ShengQin.OneShot.Utils.CaptchaGenerator;
import com.ShengQin.OneShot.Utils.MailUtil;
import com.ShengQin.OneShot.Utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {
    @Autowired
    MailUtil mailUtil;
    @Autowired
    @Qualifier("redisStorageImpl")
    TemporaryDataStoreService temporaryDataStoreService;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    CaptchaGenerator captchaGenerator;
    @Override
    public ServiceResult sendCaptchaToMailbox(String email) {
        int user_id = accountMapper.getId(email);
        String captcha = captchaGenerator.generate(DEFAULT_CAPTCHA_LENGTH);
        boolean sendResult = mailUtil.sendEmailCodeWithDefaultSender(captcha,email,"密码重置验证码");
        if (!sendResult)return ServiceResult.OTHER_FAIL;
        else {
            String key = "captcha"+user_id;
            temporaryDataStoreService.put(key,captcha,DEFAULT_CAPTCHA_EXPIRE_TIME);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public boolean verifyCaptcha(String email, String userEnteredCaptcha) {
        int user_id = accountMapper.getId(email);
        String key = "captcha"+user_id;
        Object captchaObj = temporaryDataStoreService.get(key);
        if (captchaObj!=null) {
            String captcha = (String) captchaObj;
            if (userEnteredCaptcha.equals(captcha)) {
                temporaryDataStoreService.delete(key);
                return true;
            }
        }
        return false;
    }

    @Override
    public ServiceResult resetPassword(String email,String newPassword) {
        Account account = accountMapper.getAccountByEmail(email);
        if (account==null) return ServiceResult.NONEXISTENT;
        else {
            account.setPassword(newPassword);
            try {
                accountMapper.update(account);
            }catch (Exception e) {
                System.out.println(e);
                return ServiceResult.OTHER_FAIL;//mysql 的异常，其实所有mapper.method()的地方都应该try-catch，因为mysql很可能报错
            }
            return ServiceResult.SUCCESS;
        }
    }
}
