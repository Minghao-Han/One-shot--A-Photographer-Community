package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.VO.GameParticipatorVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameParticipationMapperTest {
    @Autowired
    GameParticipationMapper gameParticipationMapper;

    @Test
    void participate() {
        GameParticipatorVO gameParticipatorVO = new GameParticipatorVO(5,4);
        gameParticipationMapper.participate(gameParticipatorVO);
    }

    @Test
    void retire() {
        gameParticipationMapper.retire(5,4);
    }

    @Test
    void participated() {
        System.out.println(gameParticipationMapper.participated(5,4));
    }

    @Test
    void getGameId() {
        System.out.println(gameParticipationMapper.getGameId(2));
    }
}