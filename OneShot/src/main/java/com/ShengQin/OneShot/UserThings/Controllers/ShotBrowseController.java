package com.ShengQin.OneShot.UserThings.Controllers;


import com.ShengQin.OneShot.UserThings.Mappers.ShotMapper;
import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import com.ShengQin.OneShot.UserThings.Services.ShotBrowseService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shotBrowse")
public class ShotBrowseController {
    @Autowired
    ShotBrowseService shotBrowseService;

    @GetMapping("/{user_id}/{pageNum}")
    public String getRecommendPage(@PathVariable("user_id")int user_id,@PathVariable("pageNum")int pageNum){
        List<ShotVO> shotVOs = shotBrowseService.getRecommendPage(user_id,pageNum);
        if (shotVOs.isEmpty()) return Result.fail("没有更多内容");
        else return Result.success("成功获得更多的shot",shotVOs);
    }

    @PostMapping("/pageView")
    public String addPageView(@RequestBody Map<String,Integer> requestBody){
        int shot_id = requestBody.get("shot_id");
        System.out.println(shot_id);
        ServiceResult serviceResult = shotBrowseService.addPageView(shot_id);
        if (serviceResult.equals(ServiceResult.NONEXISTENT)) return Result.fail("加浏览的shot不存在");
        else return Result.success("浏览量成功加一");
    }

}
