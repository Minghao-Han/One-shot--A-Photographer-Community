package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.GameInfo;

import java.util.Date;
import java.util.List;

public interface GameInfoService {
    public static final int PAGE_SIZE = 8;
    public List<GameInfo> getOngoingGame();
    public List<GameInfo> getHistoryGame(int pageNum);
    public boolean gameExist(int game_id);
    public boolean gameEnded(Date time,int game_id);
    public boolean gameStarted(Date time,int game_id);
    public boolean gameAvailable(Date time, int game_id);
}
