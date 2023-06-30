package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thumb {
    private int thumber_id;
    private int id;
    private int work_id;
    private Date time;

    public Thumb(int thumber_id, int work_id) {
        this.thumber_id = thumber_id;
        this.work_id = work_id;
    }
}
