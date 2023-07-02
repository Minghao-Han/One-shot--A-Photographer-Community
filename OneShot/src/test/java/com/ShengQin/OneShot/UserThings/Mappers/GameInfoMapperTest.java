package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.GameInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GameInfoMapperTest {
    @Autowired
    GameInfoMapper gameInfoMapper;

    @Test
    void getGameOngoing() {
        List<GameInfo> games = gameInfoMapper.getOngoingGame();
        for (GameInfo gameInfo :
                games) {
            System.out.println(games);
        }
    }

    @Test
    void getHistoryGame() {
        List<GameInfo> games = gameInfoMapper.getHistoryGame();
        for (GameInfo gameInfo :
                games) {
            System.out.println(gameInfo);
        }
    }

    @Test
    void getGame() {
        GameInfo gameInfo = gameInfoMapper.getGame(5);
        System.out.println(gameInfo);
    }
}