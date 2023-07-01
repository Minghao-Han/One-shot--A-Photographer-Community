package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.GameInfo;
import com.ShengQin.OneShot.UserThings.Mappers.GameInfoMapper;
import com.ShengQin.OneShot.UserThings.Services.GameInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GameInfoServiceImpl implements GameInfoService {
    @Autowired
    GameInfoMapper gameInfoMapper;
    @Override
    public List<GameInfo> getOngoingGame() {
        List<GameInfo> ongoingGameInfos = gameInfoMapper.getOngoingGame();
        return ongoingGameInfos;
    }

    @Override
    public List<GameInfo> getHistoryGame(int pageNum) {
        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<GameInfo> historyGameInfos = gameInfoMapper.getHistoryGame();
        return historyGameInfos;
    }
    public boolean gameExist(int game_id){
        return gameInfoMapper.gameExist(game_id);
    }
    public boolean gameEnded(Date time,int game_id){
        Date endTime = gameInfoMapper.getGame(game_id).getEnd_time();
        int compareResult = time.compareTo(endTime);//compareTo()方法的返回值，前date小于后date返回-1，前date大于后date返回1，相等返回0
        if (compareResult==1) return true;
        else return false;
    }

    @Override
    public boolean gameStarted(Date time, int game_id) {
        Date endTime = gameInfoMapper.getGame(game_id).getStart_time();
        int compareResult = time.compareTo(endTime);//compareTo()方法的返回值，前date小于后date返回-1，前date大于后date返回1，相等返回0
        if (compareResult==1) return true;
        else return false;
    }

    public boolean gameAvailable(Date time, int game_id){//有无比赛以及是否在有效期
        if (!gameExist(game_id)) return false;
        else if (!gameEnded(new Date(),game_id)&&gameStarted(new Date(),game_id)) return true;
        else return false;
    }
}
