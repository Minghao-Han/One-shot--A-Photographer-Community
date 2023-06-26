package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Services.PersonalPageService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personPage")
public class PersonalPageController {
    @Autowired
    PersonalPageService personalPageService;

    @GetMapping("/{user_id}")
    public String getPersonalPage(@PathVariable("user_id")int user_id){
        Map<String,Object> serviceResult = personalPageService.getUserInfo(user_id);
        return Result.success("获取用户主页成功",serviceResult);
    }

    @GetMapping("/{user_id}/{pageNum}")//在用户主页获取更多shot
    public String getMoreShot(@PathVariable("user_id")int user_id,@PathVariable("pageNum")int pageNum){
        List<Shot> serviceResult = personalPageService.getUserShot(user_id, pageNum);
        return Result.success("成功获得更多shot",serviceResult);
    }
}
