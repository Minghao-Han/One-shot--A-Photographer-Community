package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.PostCollectService;
import com.ShengQin.OneShot.UserThings.Services.ShotCollectService;
import com.ShengQin.OneShot.Utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
        int collector_id = requestBody.get("collector_id");
        int shot_id = requestBody.get("shot_id");
        int serviceResult = shotCollectService.collect(collector_id,shot_id);
        switch (serviceResult){
            case ShotCollectService.success -> {return Result.success("收藏成功");}
            case ShotCollectService.notExist -> {return Result.fail("收藏的作品不存在");}
            case ShotCollectService.operated -> {return Result.fail("已收藏");}
            default -> {return Result.fail("something wrong");}
        }
    }

    @DeleteMapping("/shot")
    public String shotCancelCollect(@RequestBody Map<String,Integer> requestBody){
        int collector_id = requestBody.get("collector_id");
        int shot_id = requestBody.get("shot_id");
        int serviceResult = shotCollectService.cancelCollect(collector_id,shot_id);
        switch (serviceResult){
            case ShotCollectService.success -> {return Result.success("取消收藏成功");}
            case ShotCollectService.notExist -> {return Result.fail("取消收藏的作品不存在");}
            case ShotCollectService.operated -> {return Result.fail("尚未收藏");}
            default -> {return Result.fail("something wrong");}
        }
    }

    /**post*/
    @PostMapping("/post")
    public String postCollect(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("collector_id");
        int post_id = requestBody.get("post_id");
        int serviceResult = postCollectService.collect(thumber_id,post_id);
        switch (serviceResult){
            case ShotCollectService.success -> {return Result.success("收藏成功");}
            case ShotCollectService.notExist -> {return Result.fail("收藏的作品不存在");}
            case ShotCollectService.operated -> {return Result.fail("已收藏");}
            default -> {return Result.fail("something wrong");}
        }
    }

    @DeleteMapping("/post")
    public String postCancelCollect(@RequestBody Map<String,Integer> requestBody){
        int collector_id = requestBody.get("collector_id");
        int post_id = requestBody.get("post_id");
        int serviceResult = postCollectService.cancelCollect(collector_id,post_id);
        switch (serviceResult){
            case ShotCollectService.success -> {return Result.success("取消收藏成功");}
            case ShotCollectService.notExist -> {return Result.fail("取消收藏的作品不存在");}
            case ShotCollectService.operated -> {return Result.fail("尚未收藏");}
            default -> {return Result.fail("something wrong");}
        }
    }
}