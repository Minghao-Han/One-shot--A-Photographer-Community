package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.GameParticipatorVO;

import java.util.List;

public interface GameParticipationService {
    public static final int PAGE_SIZE = 30;
    public ServiceResult participate(int participator_id,int game_id);
    public ServiceResult retire(int participator_id,int game_id);
    public boolean entryExist(int entry_id);//entry_id就是game_participation的主键id
    public int getGameId(int id);
    public List<GameParticipatorVO> getEntriesOf(int game_id,int pageNum);

}
