package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.GameInfoMapper;
import com.ShengQin.OneShot.UserThings.Mappers.GameParticipationMapper;
import com.ShengQin.OneShot.UserThings.Mappers.GameVoteMapper;
import com.ShengQin.OneShot.UserThings.Services.GameParticipationService;
import com.ShengQin.OneShot.UserThings.Services.GameVoteService;
import com.ShengQin.OneShot.Utils.ServiceResult;
import com.ShengQin.OneShot.VO.VoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameVoteServiceImpl implements GameVoteService {
    @Autowired
    GameVoteMapper gameVoteMapper;
    @Autowired
    GameParticipationMapper gameParticipationMapper;
    @Override
    public ServiceResult vote(int voter_id, int entry_id) {
        if (gameVoteMapper.voteExist(entry_id,voter_id)) return ServiceResult.OPERATED;//已经投票
        else {
            VoteVO voteVO = new VoteVO(entry_id,voter_id);
            gameVoteMapper.vote(voteVO);
            gameParticipationMapper.addTotalVotes(entry_id);
            return ServiceResult.SUCCESS;
        }
    }

    @Override
    public ServiceResult revokeVote(int voter_id, int entry_id) {
        if (!gameVoteMapper.voteExist(entry_id,voter_id)) return ServiceResult.OPERATED;//尚未投票
        else {
            gameVoteMapper.revokeVote(entry_id,voter_id);
            gameParticipationMapper.subTotalVotes(entry_id);
            return ServiceResult.SUCCESS;
        }
    }
}
