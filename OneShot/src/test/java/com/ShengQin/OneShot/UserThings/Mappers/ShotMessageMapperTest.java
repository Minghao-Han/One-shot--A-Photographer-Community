package com.ShengQin.OneShot.UserThings.Mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShotMessageMapperTest {
    @Autowired
    ShotMessageMapper shotMessageMapper;

    @Test
    void getUncheckThumbMessage() {
        List<Map<String,Object>> uncheckThumbMessages = shotMessageMapper.getUncheckThumbMessage(4);
        for (Map<String,Object> uncheckThumbMessage:uncheckThumbMessages) {
            System.out.println(uncheckThumbMessage.get("time"));
        }
    }

    @Test
    void getUncheckCommentMessage() {
        List<Map<String,Object>> uncheckCommentMessages = shotMessageMapper.getUncheckCommentMessage(4);
        for (Map<String,Object> uncheckCommentMessage:uncheckCommentMessages) {
            int shot_id = ((Long) uncheckCommentMessage.get("shot_id")).intValue();
            System.out.println(shot_id);
        }
    }

    @Test
    void getHistoryThumbMessage() {
    }

    @Test
    void getHistoryCollectMessage() {
    }

    @Test
    void checkThumbMessage() {
    }

    @Test
    void checkCommentMessage() {
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        shotMessageMapper.checkCommentMessage(ids);
        getUncheckCommentMessage();
    }
}