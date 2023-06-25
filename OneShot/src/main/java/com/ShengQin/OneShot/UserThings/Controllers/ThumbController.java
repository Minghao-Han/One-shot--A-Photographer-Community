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
        boolean successfulAdd = thumbService.shotGiveThumb(thumber_id,shot_id);
        if (successfulAdd) return Result.success("点赞成功");
        else return Result.fail("已点赞过");
    }
    @DeleteMapping("/shot")
    public String shotRevokeThumb(@RequestBody Map<String,Integer> requestBody) {
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        boolean successfulAdd = thumbService.shotRevokeThumb(thumber_id,shot_id);
        if (successfulAdd) return Result.success("取消点赞成功");
        else return Result.fail("取消点赞失败");
    }
    /**post*/
    @PostMapping("/post")
    public String postAddThumb(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        boolean successfulAdd = thumbService.postGiveThumb(thumber_id,shot_id);
        if (successfulAdd) return Result.success("点赞成功");
        else return Result.fail("已点赞过");
    }
    @DeleteMapping("/post")
    public String postCancelThumb(@RequestBody Map<String,Integer> requestBody){
        int thumber_id = requestBody.get("thumber_id");
        int shot_id = requestBody.get("shot_id");
        boolean successfulAdd = thumbService.postRevokeThumb(thumber_id,shot_id);
        if (successfulAdd) return Result.success("取消点赞成功");
        else return Result.fail("取消点赞失败");
    }
}
