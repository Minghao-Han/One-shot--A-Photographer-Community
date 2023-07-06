package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeVO {
    private int id;
    private int userId;
    private int subscribedId;
    private Date time;
    private String userName;//原名subscribedName
}
