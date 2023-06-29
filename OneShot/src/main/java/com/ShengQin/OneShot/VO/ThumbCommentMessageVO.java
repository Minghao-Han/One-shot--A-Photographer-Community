package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThumbCommentMessageVO {
    /**类型*/
//    public static final int COMMENT = 0;
//    public static final int THUMB = 1;
//    public static final int SHOT = 0;
//    public static final int POST = 1;

    private String title;//   被点赞或评论的shot/post的title
    private int from_id;
    private String from_userName;
    private int thumb_or_comment;//类型
    private int shot_or_post;//类型
    private String content;//评论的content，若是点赞信息则为null
    private Date time;
    private int shot_or_post_id;
}
