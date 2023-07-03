package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.Utils.Gender;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserService userService;

    @PutMapping
    public String editUserInfo(@RequestBody Map<String,Object> requestBody,@UserId int user_id){
        Map<String,Object> userInfo = (Map<String, Object>) requestBody.get("User");
        String userName = (String) userInfo.get("userName");
        String genderStr = (String) userInfo.get("gender");
        int age = (int) userInfo.get("age");
        String personSignature = (String) userInfo.get("personSignature");
        User updatedUser = new User(userName, user_id, Gender.getGender(genderStr), age, personSignature);
        userService.saveUser(updatedUser);
        return Result.success("修改个人信息成功");
    }
    @GetMapping
    public String getUserInfo(@UserId int user_id){
        User user = userService.getUser(user_id);
        if (user!=null) return Result.success("获取个人信息成功",user);
        else return Result.fail("用户不存在");
    }

}
