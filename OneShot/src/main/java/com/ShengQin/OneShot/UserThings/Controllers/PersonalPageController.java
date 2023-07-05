package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Services.PersonalPageService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.UserId;
import com.ShengQin.OneShot.VO.PersonalPageVO;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personPage")
public class PersonalPageController {
    @Autowired
    PersonalPageService personalPageService;

    @GetMapping
    public String getPersonalPage(@UserId int user_id){
        PersonalPageVO serviceResult = personalPageService.getUserInfo(user_id);
        return Result.success("获取用户主页成功",serviceResult);
    }

    @GetMapping("/shot/{pageNum}")//在用户主页获取更多shot
    public String getMoreShot(@UserId int user_id,@PathVariable("pageNum")int pageNum){
        List<ShotVO> serviceResult = personalPageService.getUserShot(user_id, pageNum);
        return Result.success("成功获得更多shot",serviceResult);
    }
    @GetMapping("/fans/{pageNum}")
    public String getFans(@UserId int user_id, @PathVariable("pageNum")int pageNum){
        List<User> fans = personalPageService.getFans(user_id, pageNum);
        if (fans.isEmpty()){
            return Result.fail("没有更多粉丝");
        }else {
            return Result.success("获取粉丝成功",fans);
        }
    }
}
