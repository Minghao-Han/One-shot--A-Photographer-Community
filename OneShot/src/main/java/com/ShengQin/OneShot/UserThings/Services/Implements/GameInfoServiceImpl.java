package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.GameInfo;
import com.ShengQin.OneShot.UserThings.Mappers.GameInfoMapper;
import com.ShengQin.OneShot.UserThings.Services.GameInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<GameInfo> historyGameInfos = gameInfoMapper.getOngoingGame();
        return historyGameInfos;
    }
    public boolean gameExist(int game_id){
        return gameInfoMapper.gameExist(game_id);
    }
}
