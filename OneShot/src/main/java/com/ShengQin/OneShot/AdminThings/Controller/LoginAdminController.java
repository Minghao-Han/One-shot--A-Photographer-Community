package com.ShengQin.OneShot.AdminThings.Controller;

import com.ShengQin.OneShot.AdminThings.Service.LoginAdminService;
import com.ShengQin.OneShot.Security.TokenUtil;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin/login")
public class LoginAdminController {
    @Autowired
    LoginAdminService loginAdminService;
    @PostMapping
    public String login(@RequestBody Map<String,String> data){
        //要补log
        String email = data.get("email");
        String password = data.get("password");
        if (email == null || password == null) return Result.fail("失败，账号名或密码为空");
        boolean successfulVerify = loginAdminService.verify(email,password);
        if (successfulVerify){//登录成功
            int adminId = loginAdminService.getId(email);
            String newToken = TokenUtil.createAdminToken(adminId);
            return Result.success("管理员登录成功",newToken);
        }else {//登录失败
            return Result.fail("管理员登录失败");
        }
    }
}
