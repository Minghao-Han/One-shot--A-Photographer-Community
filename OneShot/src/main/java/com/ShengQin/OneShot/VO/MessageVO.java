package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {//用于对接数据库message表用
    private int id;
    private String messageType;
    private int referencesId;//对应的具体消息表的id
    private Date time;
}
