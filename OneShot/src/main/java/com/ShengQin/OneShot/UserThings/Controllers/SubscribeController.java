package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.SubscribeService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {
    @Autowired
    SubscribeService subscribeService;

    @PostMapping
    public String subscribe(@RequestBody Map<String,Integer> requestBody){
        int subscribed_id = requestBody.get("subscribed_id");
        int user_id = requestBody.get("user_id");
        subscribeService.subscribe(user_id,subscribed_id);
        return Result.success("成功关注");
    }
    @DeleteMapping
    public String cancelSubscribe(@RequestBody Map<String,Integer> requestBody){
        int subscribed_id = requestBody.get("subscribed_id");
        int user_id = requestBody.get("user_id");
        subscribeService.cancelSubscribe(user_id,subscribed_id);
        return Result.success("成功关注");
    }

    @GetMapping("/{user_id}/{pageNum}")
    public String getSubscriptions(@PathVariable("user_id")int user_id, @PathVariable("user_id")int pageNum){
        List<Map<String,String>> serviceResult = subscribeService.getSubscribes(user_id,pageNum);
        return Result.success("获取关注成功",serviceResult);
    }
}
