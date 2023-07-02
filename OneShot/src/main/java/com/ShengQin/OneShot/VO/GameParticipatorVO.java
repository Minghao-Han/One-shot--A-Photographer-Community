package com.ShengQin.OneShot.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameParticipatorVO {
    private int id;
    private int game_id;
    private int user_id;
    private int total_votes;
    private Date time;

    public GameParticipatorVO(int game_id, int user_id) {
        this.game_id = game_id;
        this.user_id = user_id;
    }
}
