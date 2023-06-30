package com.ShengQin.OneShot.UserThings.Mappers.MessageMappers;

import com.ShengQin.OneShot.VO.MessageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {
    @Autowired
    MessageMapper messageMapper;

    @Test
    void setMessageChecked() {
        List<Integer> ids = new ArrayList<>();
        ids.add(11);
        ids.add(16);
        ids.add(17);
        ids.add(18);
        messageMapper.setMessageChecked(ids);
    }

    @Test
    void getUncheckMessageVOs() {
//        List<MessageVO> messageVOs = messageMapper.getUncheckMessageVOs1(4);
//        List<Integer> checkedIds = new ArrayList<>();
//        for (MessageVO messageVO:messageVOs) {
//            checkedIds.add(messageVO.getId());
//        }
//        System.out.println(checkedIds);
//        messageMapper.setMessageChecked(checkedIds);
        List<MessageVO> messageVOs = messageMapper.getUncheckMessageVOs(4);
    }

    @Test
    void getHistoryMessageVOs() {
    }
}