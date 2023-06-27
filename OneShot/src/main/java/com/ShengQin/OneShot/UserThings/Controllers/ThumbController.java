package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.ThumbService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/thumb")
public class ThumbController {
    @Autowired
    ThumbService thumbService;

    @PostMapping("/shot")
    public String shotGiveThumb(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        int serviceResult = thumbService.shotGiveThumb(thumber_id,shot_id);
        switch (serviceResult){
            case ThumbService.success -> {return Result.success("点赞成功");}
            case ThumbService.notExist -> {return Result.fail("点赞的作品不存在");}
            case ThumbService.operated -> {return Result.fail("已点赞过");}
            default -> {return Result.fail("something wrong");}
        }
    }
    @DeleteMapping("/shot")
    public String shotRevokeThumb(@RequestBody Map<String,Integer> requestBody) {
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        int serviceResult = thumbService.shotRevokeThumb(thumber_id,shot_id);
        switch (serviceResult){
            case ThumbService.success -> {return Result.success("取消点赞成功");}
            case ThumbService.notExist -> {return Result.fail("取消点赞的作品不存在");}
            case ThumbService.operated -> {return Result.fail("尚未点赞");}
            default -> {return Result.fail("something wrong");}
        }
    }
    /**post*/
    @PostMapping("/post")
    public String postAddThumb(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        int serviceResult = thumbService.postGiveThumb(thumber_id,shot_id);
        switch (serviceResult){
            case ThumbService.success -> {return Result.success("点赞成功");}
            case ThumbService.notExist -> {return Result.fail("点赞的作品不存在");}
            case ThumbService.operated -> {return Result.fail("已点赞过");}
            default -> {return Result.fail("something wrong");}
        }
    }
    @DeleteMapping("/post")
    public String postCancelThumb(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        int serviceResult = thumbService.postRevokeThumb(thumber_id,shot_id);
        switch (serviceResult){
            case ThumbService.success -> {return Result.success("取消点赞成功");}
            case ThumbService.notExist -> {return Result.fail("取消点赞的作品不存在");}
            case ThumbService.operated -> {return Result.fail("尚未点赞");}
            default -> {return Result.fail("something wrong");}
        }
    }
}
