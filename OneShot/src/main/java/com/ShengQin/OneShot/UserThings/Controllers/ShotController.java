package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shot")
public class ShotController {
    @Autowired
    ShotService shotService;

    @PostMapping
    public String createShot(@RequestBody Map<String,Object> requestBody){
        int user_id = (int)requestBody.get("user_id");
        String title = (String) requestBody.get("title");
        String content = (String) requestBody.get("content");
        List<String> tags = (List<String>) requestBody.get("tags");
        Date time = (Date) requestBody.get("time");
        shotService.createShot(user_id,title,content,time,tags);
        return Result.success("创建shot成功");
    }

    @DeleteMapping
    public String deleteShot(@RequestBody Map<String,Integer> requestBody){
        int shot_id = (int) requestBody.get("shot_id");
        shotService.delete(shot_id);
        return Result.success("删除成功");
    }
}
