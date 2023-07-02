package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.VO.VoteVO;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameVoteMapperTest {
    @Autowired
    GameVoteMapper gameVoteMapper;

    @Test
    void voteExist() {
        boolean exist = gameVoteMapper.voteExist(2,4);
        System.out.println(exist);
    }

    @Test
    void vote() {
        VoteVO voteVO = new VoteVO(2,4);
        gameVoteMapper.vote(voteVO);
    }

    @Test
    void revokeVote() {
        gameVoteMapper.revokeVote(2,4);
    }
}