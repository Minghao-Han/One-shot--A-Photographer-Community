package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentAdminPost {
    private int id;
    private int inner_id;
    private int post_id;
    private int parent_id;
    private int commentator_id;
    private String content;
    private Timestamp time;
    private int is_read;
}
