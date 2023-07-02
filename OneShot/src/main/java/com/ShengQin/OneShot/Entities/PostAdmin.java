package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostAdmin {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private int total_thumb;
    private int total_collect;
    private int page_view;
    private Timestamp time;
}
