package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.Security.TokenUtil;
import com.ShengQin.OneShot.UserThings.Services.MessageService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/history/{user_id}/{pageNum}")
    public String getHistoryMessage(@PathVariable("user_id") int user_id, @PathVariable("pageNum") int pageNum,@RequestHeader Map<String,String> requestHeader){
        String token = (String) requestHeader.get("token");
        if (!TokenUtil.IdPermissionCheck(token,user_id)) return Result.fail("失败，不能看别人的信息");
        List<Message> historyMessage = messageService.getHistoryMessage(user_id,pageNum);
        return Result.success("成功获得信息",historyMessage);
    }
    @GetMapping("/uncheck")
    public String getHistoryMessage(@PathVariable("user_id") int user_id,@RequestHeader Map<String,String> requestHeader){
        String token = (String) requestHeader.get("token");
        if (!TokenUtil.IdPermissionCheck(token,user_id)) return Result.fail("失败，不能看别人的信息");
        List<Message> uncheckMessage = messageService.getUncheckMessage(user_id);
        return Result.success("成功获得信息",uncheckMessage);
    }
}
