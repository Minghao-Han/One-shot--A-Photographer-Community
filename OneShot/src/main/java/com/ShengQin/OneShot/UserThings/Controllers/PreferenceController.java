package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/preference")
public class PreferenceController {
    @Autowired
    PreferenceService preferenceService;

    @PostMapping
    public String addPreferences(@RequestBody Map<String,Object> requestBody, @UserId int user_id){
        List<String> tags = (List<String>) requestBody.get("tags");
        preferenceService.addPreferences(tags,user_id);
        return Result.success("添加喜好成功");
    }

    @DeleteMapping
    public String removePreferences(@RequestBody Map<String,Object> requestBody,@UserId int user_id){
        List<String> tags = (List<String>) requestBody.get("tags");
        preferenceService.removePreferences(tags,user_id);
        return Result.success("移除喜好成功");
    }

    @GetMapping
    public String checkPreferences(@UserId int user_id){
        List<String> serviceResult = preferenceService.getPreferences(user_id);
        return Result.success("获取用户喜好成功",serviceResult);
    }
}
