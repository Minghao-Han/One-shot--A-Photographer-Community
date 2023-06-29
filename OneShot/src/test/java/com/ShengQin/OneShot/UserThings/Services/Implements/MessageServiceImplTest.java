package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.MessageService;
import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.VO.ThumbCommentMessageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MessageServiceImplTest {
    @Autowired
    MessageService messageService;

    @Test
    void getUncheckMessage() {
        List<Message> uncheckMessages = messageService.getUncheckMessages(4);
        for (Message message :
                uncheckMessages) {
            System.out.println(message);
        }
    }
}