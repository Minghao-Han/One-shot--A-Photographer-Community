package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.GameParticipationMapper;
import com.ShengQin.OneShot.UserThings.Services.GameInfoService;
import com.ShengQin.OneShot.UserThings.Services.GameParticipationService;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.GameParticipatorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameParticipationServiceImpl implements GameParticipationService {
    @Autowired
    GameParticipationMapper gameParticipationMapper;
    @Autowired
    GameInfoService gameInfoService;
    @Override
    public ServiceResult participate(int participator_id, int game_id) {//参加比赛
        if(gameParticipationMapper.participated(game_id,participator_id)) return ServiceResult.OPERATED;//已参加
        else if (!gameInfoService.gameExist(game_id)) return ServiceResult.NONEXISTENT;//要参加的比赛不存在
        else {
            GameParticipatorVO gameParticipatorVO = new GameParticipatorVO(game_id,participator_id);
            gameParticipationMapper.participate(gameParticipatorVO);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public ServiceResult retire(int participator_id, int game_id) {//退出比赛
        if(!gameParticipationMapper.participated(game_id,participator_id)) return ServiceResult.OPERATED;//尚未参加
        else if (!gameInfoService.gameExist(game_id)) return ServiceResult.NONEXISTENT;//要退出的比赛不存在
        else {
            gameParticipationMapper.retire(game_id,participator_id);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public boolean entryExist(int entry_id) {
        return gameParticipationMapper.entryExist(entry_id);
    }
}
