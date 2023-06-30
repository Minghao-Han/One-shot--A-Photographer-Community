package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.GeneralMessageService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.VO.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GeneralMessageServiceImplTest {
    @Autowired
    GeneralMessageService generalMessageService;

//    @Test
//    void getUncheckMessage() {
//        generalMessageService.registerSubMessageService();
//        List<Message> uncheckMessages = generalMessageService.getUncheckMessages(4);
//        System.out.println("uncheckMessages is empty "+uncheckMessages.isEmpty());
//        for (Message message :
//                uncheckMessages) {
//            System.out.println(message);
//        }
//    }

    @Test
    void getUncheckMessages() {
    }

    @Test
    void getUncheckMessagesTest() {
        generalMessageService.registerSubMessageService();
        List<Message> uncheckMessages = generalMessageService.getUncheckMessages(4);
        System.out.println("uncheckMessages is empty "+uncheckMessages.isEmpty());
        for (Message message :
                uncheckMessages) {
            System.out.println(message);
        }

    }

    @Test
    void getHistoryMessage() {
        generalMessageService.registerSubMessageService();
        List<Message> historyMessages = generalMessageService.getHistoryMessage(4,0);
        if (!historyMessages.isEmpty()) System.out.println(Result.success("成功获得信息", historyMessages));
        else System.out.println(Result.fail("没有更多历史消息"));
    }
}