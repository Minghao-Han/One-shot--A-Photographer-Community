package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.Security.TokenUtil;
import com.ShengQin.OneShot.UserThings.Services.LoginService;
import com.ShengQin.OneShot.UserThings.Services.RegisterService;
import com.ShengQin.OneShot.Utils.Gender;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
//    @Autowired
//    LoginService loginService;
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public String login(@RequestBody Map<String,Object> requestBody){
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");

        Map<String,Object> userInfo = (Map<String, Object>) requestBody.get("User");
        String userName = (String) userInfo.get("userName");
        String genderStr = (String) userInfo.get("gender");
        int age = (int) userInfo.get("age");
        String personSignature = (String) userInfo.get("personSignature");

        User newUser = new User(userName,Gender.getGender(genderStr) ,age,personSignature);
        boolean registerResult = registerService.register(email,password,newUser);
        if (registerResult) return Result.success("注册成功");
        else return Result.fail("邮箱已被占用");
    }
}
