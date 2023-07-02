package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteVO {
    private int id;
    private int entry_id;//被投票的作品的id，关联game_participation的id
    private int voter_id;//谁投的票
    private Date time;//投票时间

    public VoteVO(int entry_id, int voter_id) {
        this.entry_id = entry_id;
        this.voter_id = voter_id;
    }
}
