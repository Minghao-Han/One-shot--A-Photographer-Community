package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Utils.UserId;
import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.Security.TokenUtil;
import com.ShengQin.OneShot.UserThings.Services.GeneralMessageService;
import com.ShengQin.OneShot.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    GeneralMessageService generalMessageService;

    @GetMapping("/history/{pageOffset}")
    public String getHistoryMessage(@UserId int user_id, @PathVariable("pageOffset") int pageOffset, @RequestHeader Map<String,String> requestHeader){
        String token = (String) requestHeader.get("token");
        if (!TokenUtil.IdPermissionCheck(token,user_id)) return Result.fail("失败，不能看别人的信息");
        generalMessageService.registerSubMessageService();
        List<Message> historyMessages = generalMessageService.getHistoryMessage(user_id,pageOffset);
        if (!historyMessages.isEmpty())return Result.success("成功获得信息", historyMessages);
        else return Result.fail("没有更多历史消息");
    }
    @GetMapping("/uncheck")
    public String getHistoryMessage(@UserId int user_id,@RequestHeader Map<String,String> requestHeader){
        String token = (String) requestHeader.get("token");
        if (!TokenUtil.IdPermissionCheck(token,user_id)) return Result.fail("失败，不能看别人的信息");
        generalMessageService.registerSubMessageService();
        List<Message> uncheckMessages = generalMessageService.getUncheckMessages(user_id);
        if (uncheckMessages.isEmpty()) return Result.fail("没有更多新消息");
        return Result.success("成功获得信息", uncheckMessages);
    }
}
