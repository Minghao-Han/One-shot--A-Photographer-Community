package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.GameInfoMapper;
import com.ShengQin.OneShot.UserThings.Services.GameInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameInfoServiceImplTest {
    @Autowired
    GameInfoService gameInfoService;
    @Test
    void gameAvailable() {
        boolean result = gameInfoService.gameAvailable(new Date(),5);
        System.out.println("game is available "+result);
    }
}