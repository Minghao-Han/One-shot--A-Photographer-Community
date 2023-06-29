package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class Message<T> implements Serializable {//向前端传的message
    private String messageText;
    private T messageData;
    Date time;
    private String messageType;
    public Message(String messageText, T messageData) {
        this.messageText = messageText;
        this.messageData = messageData;
    }
}
