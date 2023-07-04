package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.PasswordResetService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.Utils.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("password/reset")
public class PasswordResetController {
    @Autowired
    PasswordResetService passwordResetService;
    @GetMapping
    public String sendCaptchaToMailBox(@UserId int user_id){
        ServiceResult serviceResult = passwordResetService.sendCaptchaToMailbox(user_id);
        switch (serviceResult){
            case SUCCESS -> {return Result.success("请查看邮箱中的验证码");}
            case OTHER_FAIL -> {return Result.fail("验证码发送失败");}
            case default -> {return Result.fail("未知错误");}
        }
    }

    @PostMapping
    public String verifyCaptcha(@RequestBody Map<String,Object> requestBody,@UserId int user_id){
        Object userEnterCaptchaObj = requestBody.get("captcha");
        if (userEnterCaptchaObj==null) return Result.fail("未输入验证码");
        String userEnterCaptcha = (String) userEnterCaptchaObj;
        if (passwordResetService.verifyCaptcha(user_id,userEnterCaptcha)) return Result.success("验证码验证成功");
        else return Result.fail("验证码验证失败");
    }

    @PutMapping
    public String resetPassword(@RequestBody Map<String,Object> requestBody,@UserId int user_id){
        Object newPasswordObj = requestBody.get("newPassword");
        if (newPasswordObj==null) return Result.fail("未输入验证码");
        String newPassword = (String) newPasswordObj;
        ServiceResult serviceResult = passwordResetService.resetPassword(user_id,newPassword);
        switch (serviceResult){
            case SUCCESS -> {return Result.success("更改密码成功");}
            case OTHER_FAIL -> {return Result.fail("写入数据库异常");}
            case NONEXISTENT -> {return Result.fail("账号不存在");}
            case default -> {return Result.fail("未知错误");}
        }
    }
}
