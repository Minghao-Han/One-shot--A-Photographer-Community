package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.ShengQin.OneShot.Utils.ServiceResult.OPERATED;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {
    @Autowired
    SubscribeService subscribeService;

    @PostMapping
    public String subscribe(@RequestBody Map<String,Integer> requestBody){
        int subscribed_id = requestBody.get("subscribed_id");
        int user_id = requestBody.get("user_id");
        if (subscribed_id==user_id) return Result.fail("不能关注自己");
        ServiceResult serviceResult = subscribeService.subscribe(user_id,subscribed_id);
        switch (serviceResult){
            case OPERATED -> {
                return Result.fail("已关注过");
            }
            case SUCCESS -> {
                return Result.success("成功关注");
            }
            case NONEXISTENT -> {
                return Result.fail("您要关注的用户不存在");
            }
            default ->{return Result.fail("something wrong");}
        }
    }
    @DeleteMapping
    public String cancelSubscribe(@RequestBody Map<String,Integer> requestBody){
        int subscribed_id = requestBody.get("subscribed_id");
        int user_id = requestBody.get("user_id");
        ServiceResult serviceResult = subscribeService.cancelSubscribe(user_id,subscribed_id);
        switch (serviceResult){
            case OPERATED -> {
                return Result.fail("尚未关注");
            }
            case SUCCESS -> {
                return Result.success("成功取消关注");
            }
            default ->{return Result.fail("something wrong");}
        }
    }

    @GetMapping("/{user_id}/{pageNum}")
    public String getSubscriptions(@PathVariable("user_id")int user_id, @PathVariable("user_id")int pageNum){
        List<Map<String,String>> serviceResult = subscribeService.getSubscribes(user_id,pageNum);
        return Result.success("获取关注成功",serviceResult);
    }
}
