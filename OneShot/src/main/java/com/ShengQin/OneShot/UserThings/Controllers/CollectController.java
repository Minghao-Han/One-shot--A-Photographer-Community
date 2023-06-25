package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.PostCollectService;
import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    ShotCollectService shotCollectService;
    @Autowired
    PostCollectService postCollectService;

    /**shot*/
    @PostMapping("/shot")
    public String shotCollect(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        boolean successfulAdd = shotCollectService.collect(thumber_id,shot_id);
        if (successfulAdd) return Result.success("收藏成功");
        else return Result.fail("已收藏");
    }

    @DeleteMapping("/shot")
    public String shotCancelCollect(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        boolean successfulAdd = shotCollectService.collect(thumber_id,shot_id);
        if (successfulAdd) return Result.success("取消收藏成功");
        else return Result.fail("取消收藏失败");
    }

    /**post*/
    @PostMapping("/post")
    public String postCollect(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("post_id");
        boolean successfulAdd = postCollectService.collect(thumber_id,shot_id);
        if (successfulAdd) return Result.success("收藏成功");
        else return Result.fail("已收藏");
    }

    @DeleteMapping("/post")
    public String postCancelCollect(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("post_id");
        boolean successfulAdd = postCollectService.collect(thumber_id,shot_id);
        if (successfulAdd) return Result.success("取消收藏成功");
        else return Result.fail("取消收藏失败");
    }
}
