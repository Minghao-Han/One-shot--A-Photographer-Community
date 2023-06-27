package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.Utils.Gender;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserService userService;

    @PutMapping
    public String editUserInfo(@RequestBody Map<String,Object> requestBody){
        Map<String,Object> userInfo = (Map<String, Object>) requestBody.get("User");
        String userName = (String) userInfo.get("userName");
        String genderStr = (String) userInfo.get("gender");
        int age = (int) userInfo.get("age");
        int id = (int) userInfo.get("id");
        String personSignature = (String) userInfo.get("personSignature");
        User updatedUser = new User(userName, id, Gender.getGender(genderStr), age, personSignature);
        userService.saveUser(updatedUser);
        return Result.success("修改个人信息成功");
    }
}
