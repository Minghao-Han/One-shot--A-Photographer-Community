package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;

public interface GameParticipationService {
    public ServiceResult participate(int participator_id,int game_id);
    public ServiceResult retire(int participator_id,int game_id);
    public boolean entryExist(int entry_id);//entry_id就是game_participation的主键id
    public int getGameId(int id);
}
