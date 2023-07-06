package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.GameParticipationMapper;
import com.ShengQin.OneShot.UserThings.Services.GameParticipationService;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.GameParticipatorVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameParticipationServiceImpl implements GameParticipationService {
    @Autowired
    GameParticipationMapper gameParticipationMapper;
    @Override
    public ServiceResult participate(int participator_id, int game_id) {//参加比赛
        if (gameParticipationMapper.participated(game_id,participator_id)) return ServiceResult.OPERATED;//已经参加
        else {
            GameParticipatorVO gameParticipatorVO = new GameParticipatorVO(game_id,participator_id);
            gameParticipationMapper.participate(gameParticipatorVO);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public ServiceResult retire(int participator_id, int game_id) {//退出比赛
        if (!gameParticipationMapper.participated(game_id,participator_id)) return ServiceResult.OPERATED;//尚未参加
        else {
            gameParticipationMapper.retire(game_id,participator_id);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public boolean entryExist(int entry_id) {
        return gameParticipationMapper.entryExist(entry_id);
    }

    @Override
    public int getGameId(int id) {
        return gameParticipationMapper.getGameId(id);
    }

    @Override
    public List<GameParticipatorVO> getEntriesOf(int game_id,int pageNum) {
        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<GameParticipatorVO> entries = gameParticipationMapper.getAllEntriesOfGame(game_id);
        return entries;
    }
}
