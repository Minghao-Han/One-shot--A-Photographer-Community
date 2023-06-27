package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Mappers.ShotMapper;
import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import com.ShengQin.OneShot.UserThings.Services.ShotBrowseService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shotBrowse")
public class ShotBrowseController {
    @Autowired
    ShotBrowseService shotBrowseService;

    @GetMapping("/{user_id}/{pageNum}")
    public String getRecommendPage(@PathVariable("user_id")int user_id,@PathVariable("pageNum")int pageNum){
        List<Shot> shots = shotBrowseService.getRecommendPage(user_id,pageNum);
        if (shots.isEmpty()) return Result.fail("没有更多内容");
        else return Result.success("成功获得更多的shot",shots);
    }

}
