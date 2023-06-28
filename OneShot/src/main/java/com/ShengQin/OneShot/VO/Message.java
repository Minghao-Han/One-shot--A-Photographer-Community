package com.ShengQin.OneShot.VO;

import com.ShengQin.OneShot.Entities.Comment;
import lombok.Data;

@Data
public class Message {
    /**类型*/
    public static final int COMMENT = 0;
    public static final int THUMB = 1;

    private int from_id;
    private String from_userName;
    private int type;
    private String content;

    private Message(int from_id, String from_userName, int type, String content) {
        this.from_id = from_id;
        this.from_userName = from_userName;
        this.type = type;
        this.content = content;
    }

    public Message thumbedMessage(int from_id,String from_userName){
        return new Message(from_id,from_userName,THUMB,null);
    }
    public Message collectedMessage(Comment comment, String from_userName){
        int from_id = comment.getCommentator_id();
        String content = comment.getContent();
        return new Message(from_id,from_userName,COMMENT,content);
    }
}
