package com.ShengQin.OneShot.ScheduleJob;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameScheduleMapperTest {
    @Autowired
    GameScheduleMapper gameScheduleMapper;


    @Test
    void getFinishedNoWinnerGames() {
        System.out.println(gameScheduleMapper.getUnfinishedGames());
    }

    @Test
    void getUnfinishedGames() {
    }

    @Test
    void selectWinner() {
        Integer winner_id = gameScheduleMapper.selectWinner(17);
        System.out.println(winner_id);
    }

    @Test
    void setWinner() {
    }
}