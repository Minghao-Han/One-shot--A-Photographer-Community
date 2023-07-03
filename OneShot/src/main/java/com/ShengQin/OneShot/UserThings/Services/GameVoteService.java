package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Utils.ServiceResult;

public interface GameVoteService {
    public ServiceResult vote(int voter_id,int entry_id);
    public ServiceResult revokeVote(int voter_id,int entry_id);
}
