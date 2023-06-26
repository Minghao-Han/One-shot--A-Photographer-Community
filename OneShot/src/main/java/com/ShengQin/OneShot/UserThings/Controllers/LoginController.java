package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Security.TokenUtil;
import com.ShengQin.OneShot.UserThings.Services.Implements.LoginServiceImpl;
import com.ShengQin.OneShot.UserThings.Services.LoginService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> data){
        //要补log
        String email = data.get("email");
        String password = data.get("password");
        if (email == null || password == null) return Result.fail("失败，账号名或密码为空");
        boolean successfulVerify = loginService.verify(email,password);
        if (successfulVerify){//登录成功
            int userId = loginService.getId(email);
            String newToken = TokenUtil.createToken(userId);
            return Result.success("登录成功",newToken);
        }else {//登录失败
            return Result.fail("登录失败");
        }
    }
}