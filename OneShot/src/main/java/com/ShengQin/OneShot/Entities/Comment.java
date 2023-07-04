package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private int innerID;//在一条shot或post中的id
    private int shotId;
    private int receiverId;//被评论的人的id

    private int parentId;
    private int commentatorId;
    private Date time;
    private String content;

    public Comment(int innerID, int shotId, int parentId, int commentatorId, String content, int receiverId) {
        this.innerID = innerID;
        this.shotId = shotId;
        this.parentId = parentId;
        this.commentatorId = commentatorId;
        this.content = content;
        this.receiverId = receiverId;
    }
}
