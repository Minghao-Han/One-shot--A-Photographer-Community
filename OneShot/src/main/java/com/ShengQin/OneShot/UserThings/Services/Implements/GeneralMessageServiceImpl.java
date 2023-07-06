package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.MessageMappers.MessageMapper;
import com.ShengQin.OneShot.UserThings.Services.SubMessageServices.AbstractSubMessageService;
import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.UserThings.Services.GeneralMessageService;
import com.ShengQin.OneShot.VO.MessageVO;
import com.github.pagehelper.PageHelper;
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
        List<Message> uncheckMessages = new ArrayList<>();//Message是发给前端的
        List<MessageVO> uncheckMessageVOs = messageMapper.getUncheckMessageVOs(user_id);//MessageVO是用来接收数据库数据的，此处从message表按时间获取消息
        for (MessageVO messageVO :uncheckMessageVOs) {
            String messageType = messageVO.getMessageType();
            int references_id = messageVO.getReferencesId();
            Date time = messageVO.getTime();
            AbstractSubMessageService subMessageService = subMessageServiceSelector.get(subMessageServiceMap.get(messageType));//根据消息类型选择对应的service
            Message message = subMessageService.getMessage(references_id);
            message.setTime(time);
            message.setMessageType(messageType);
            uncheckMessages.add(message);
        }
        uncheckMessages.sort(Comparator.comparing(Message::getTime));
        return uncheckMessages;//返回Message对象
    }

    @Override
    public List<Message> getHistoryMessage(int user_id, int pageOffset) {
        List<Message> historyMessages = new ArrayList<>();
        PageHelper.offsetPage(pageOffset,PAGE_SIZE);
        List<MessageVO> historyMessageVOs = messageMapper.getHistoryMessageVOs(user_id);
        for (MessageVO messageVO :historyMessageVOs) {
            String messageType = messageVO.getMessageType();
            int references_id = messageVO.getReferencesId();
            Date time = messageVO.getTime();
            System.out.println(subMessageServiceMap.get(messageType));
            AbstractSubMessageService subMessageService = subMessageServiceSelector.get(subMessageServiceMap.get(messageType));
            Message message = subMessageService.getMessage(references_id);
            message.setTime(time);
            message.setMessageType(messageType);
            historyMessages.add(message);
        }
        return historyMessages;
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
