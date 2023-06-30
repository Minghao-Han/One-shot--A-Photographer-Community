package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.MessageMapper;
import com.ShengQin.OneShot.UserThings.Services.SubMessageServices.AbstractSubMessageService;
import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.UserThings.Services.GeneralMessageService;
import com.ShengQin.OneShot.VO.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GeneralMessageServiceImpl implements GeneralMessageService {
    @Autowired
    Map<String, AbstractSubMessageService> subMessageServiceSelector;
    @Autowired
    MessageMapper messageMapper;
    private Map<String,String> subMessageServiceMap = new HashMap<>();


    @Override
    public List<Message> getUncheckMessages(int user_id) {
        List<Message> uncheckMessages = new ArrayList<>();
        List<MessageVO> uncheckMessageVOs = messageMapper.getUncheckMessageVOs(user_id);
        for (MessageVO messageVO :uncheckMessageVOs) {
            String messageType = messageVO.getMessageType();
            int references_id = messageVO.getReferencesId();
            Date time = messageVO.getTime();
            System.out.println(subMessageServiceMap.get(messageType));
            AbstractSubMessageService subMessageService = subMessageServiceSelector.get(subMessageServiceMap.get(messageType));
            Message message = subMessageService.getMessage(references_id);
            message.setTime(time);
            message.setMessageType(messageType);
            uncheckMessages.add(message);
        }
        uncheckMessages.sort(Comparator.comparing(Message::getTime));
        return uncheckMessages;
    }

    @Override
    public List<Message> getHistoryMessage(int user_id, int pageNum) {
        return null;
    }

    @Override
    public void registerSubMessageService() {
//        subMessageServiceSelector.put(messageType,subMessageService); <--格式
        subMessageServiceMap.put("thumb_of_shot","shotThumbMessageService");
        subMessageServiceMap.put("thumb_of_post","postThumbMessageService");
        subMessageServiceMap.put("comment_of_shot","shotCommentMessageService");
        subMessageServiceMap.put("comment_of_post","postCommentMessageService");
    }
}
