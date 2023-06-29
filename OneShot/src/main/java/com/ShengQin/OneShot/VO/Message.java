package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class Message<T> implements Serializable {
    private String messageText;
    private T messageData;
    Date time;
}
