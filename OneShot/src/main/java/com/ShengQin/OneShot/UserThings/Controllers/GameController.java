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

import java.util.Date;
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
        if (ongoingGameInfos.isEmpty()) return Result.fail("没有更多正在进行的比赛");
        else {
            return Result.success("获得正在进行比赛成功",ongoingGameInfos);
        }
    }
    @GetMapping("/history/{pageNum}")
    public String getHistoryGame(@PathVariable("pageNum")int pageNum){
        List<GameInfo> historyGameInfos = gameInfoService.getHistoryGame(pageNum);
        if (historyGameInfos.isEmpty()) return Result.fail("没有更多历史的比赛");
        else {
            return Result.success("获得历史比赛成功",historyGameInfos);
        }
    }
    @PostMapping("/vote")
    public String vote(@UserId int user_id, @RequestBody Map<String,Object> requestBody){
        Integer entry_id = (Integer) requestBody.get("entry_id");
        if (!gameParticipationService.entryExist(entry_id)) return Result.fail("投票的作品不存在");
        Integer game_id = gameParticipationService.getGameId(entry_id);//获取这个作品对应的比赛的id
        if (!gameInfoService.gameAvailable(new Date(),game_id)) return Result.fail("比赛已经结束");
        else {
            ServiceResult serviceResult = gameVoteService.vote(user_id,entry_id);
            if (serviceResult.equals(ServiceResult.SUCCESS)) return Result.success("投票成功");
            else if (serviceResult.equals(ServiceResult.OPERATED)) return Result.fail("不能重复投票");
            else return Result.fail("未知错误");
        }
    }
    @DeleteMapping("/vote")
    public String revokeVote(@UserId int user_id, @RequestBody Map<String,Object> requestBody){
        Integer entry_id = (Integer) requestBody.get("entry_id");
        if (!gameParticipationService.entryExist(entry_id)) return Result.fail("撤销投票的作品不存在");
        Integer game_id = gameParticipationService.getGameId(entry_id);//获取这个作品对应的比赛的id
        if (!gameInfoService.gameAvailable(new Date(),game_id)) return Result.fail("比赛已经结束，不能撤回投票");
        else {
            ServiceResult serviceResult = gameVoteService.revokeVote(user_id,entry_id);
            if (serviceResult.equals(ServiceResult.SUCCESS)) return Result.success("撤回投票成功");
            else if (serviceResult.equals(ServiceResult.OPERATED)) return Result.fail("尚未投票");
            else return Result.fail("未知错误");
        }
    }
    @PostMapping("/participate")
    public String participateGame(@UserId int user_id, @RequestBody Map<String,Object> requestBody){
        Integer game_id = (Integer) requestBody.get("game_id");
        if (!gameInfoService.gameExist(game_id)) return Result.fail("比赛不存在");
        else if (!gameInfoService.gameAvailable(new Date(),game_id)) return Result.fail("比赛已经结束，不能参加");
        else {
            ServiceResult serviceResult = gameParticipationService.participate(user_id,game_id);
            if (serviceResult.equals(ServiceResult.SUCCESS)) return Result.success("成功参加比赛");
            else if (serviceResult.equals(ServiceResult.OPERATED)) return Result.fail("已经参加过");
            else return Result.fail("未知错误");
        }
    }
    @DeleteMapping("/participate")
    public String retireFromGame(@UserId int user_id, @RequestBody Map<String,Object> requestBody){
        Integer game_id = (Integer) requestBody.get("game_id");
        if (!gameInfoService.gameExist(game_id)) return Result.fail("比赛不存在");
        else if (!gameInfoService.gameAvailable(new Date(),game_id)) return Result.fail("比赛已经结束，不能退出");
        else {
            ServiceResult serviceResult = gameParticipationService.retire(user_id,game_id);
            if (serviceResult.equals(ServiceResult.SUCCESS)) return Result.success("成功退出比赛");
            else if (serviceResult.equals(ServiceResult.OPERATED)) return Result.fail("尚未参加比赛");
            else return Result.fail("未知错误");
        }
    }
}
