package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.GameInfo;
import com.ShengQin.OneShot.UserThings.Services.GameInfoService;
import com.ShengQin.OneShot.UserThings.Services.GameParticipationService;
import com.ShengQin.OneShot.UserThings.Services.GameVoteService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.Utils.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("game")
public class GameController {
    @Autowired
    GameParticipationService gameParticipationService;
    @Autowired
    GameVoteService gameVoteService;
    @Autowired
    GameInfoService gameInfoService;

    @GetMapping("/ongoing")
    public String getOngoingGame(){
        List<GameInfo> ongoingGameInfos = gameInfoService.getOngoingGame();
        if (!ongoingGameInfos.isEmpty()) return Result.fail("没有更多正在进行的比赛");
        else {
            return Result.success("获得正在进行比赛成功",ongoingGameInfos);
        }
    }
    @GetMapping("/history")
    public String getHistoryGame(){
        List<GameInfo> historyGameInfos = gameInfoService.getOngoingGame();
        if (!historyGameInfos.isEmpty()) return Result.fail("没有更多历史的比赛");
        else {
            return Result.success("获得历史比赛成功",historyGameInfos);
        }
    }
    @PostMapping("/vote")
    public String vote(@UserId int user_id, @RequestBody Map<String,Object> requestBody){
        Integer entry_id = (Integer) requestBody.get("entry_id");
        ServiceResult serviceResult = gameVoteService.vote(user_id,entry_id);
        switch (serviceResult){
            case NONEXISTENT -> {return Result.fail("您投票的比赛不存在");}
            case OPERATED -> {return Result.fail("您已投票过，不能重复投票");}
            case SUCCESS -> {return Result.success("投票成功");}
            case default -> {return Result.success("未知错误");}
        }
    }
    @DeleteMapping("/vote")
    public String revokeVote(@UserId int user_id, @RequestBody Map<String,Object> requestBody){

    }
    @PostMapping("/participate")
    public String participateGame(@UserId int user_id, @RequestBody Map<String,Object> requestBody){

    }
    @DeleteMapping("/participate")
    public String retireFromGame(@UserId int user_id, @RequestBody Map<String,Object> requestBody){

    }
}
