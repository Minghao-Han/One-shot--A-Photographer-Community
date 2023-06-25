package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Comment {
    private int comment_id;
    private int shot_id;
    private int parent_id;
    private int commentator_id;
    private Date time;
    private String content;
}
