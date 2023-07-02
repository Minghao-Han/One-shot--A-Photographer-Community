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
    private int shot_id;
    private int receiver_id;//被评论的人的id

    private int parent_id;
    private int commentator_id;
    private Date time;
    private String content;

    public Comment(int innerID, int shot_id, int parent_id, int commentator_id, String content,int receiver_id) {
        this.innerID = innerID;
        this.shot_id = shot_id;
        this.parent_id = parent_id;
        this.commentator_id = commentator_id;
        this.content = content;
        this.receiver_id=receiver_id;
    }
}