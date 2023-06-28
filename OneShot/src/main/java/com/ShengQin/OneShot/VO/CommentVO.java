package com.ShengQin.OneShot.VO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CommentVO {
    private int id;
    private int innerID;//在一条shot或post中的id
    private int shot_id;
    private int receiver_id;
    private int commentator_id;
    private Date time;
    private String content;
    private String commentatorUserName;//发评论的人的用户名
    private String receiverUserName;//被评论的人的用户名
}
