package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.VO.VoteVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface GameVoteMapper {
    @Select("select count(*) from vote_of_game where entry_id=#{entry_id} and voter_id=#{voter_id}")
    public boolean voteExist(int entry_id,int voter_id);
    @Insert("insert into vote_of_game(entry_id,voter_id) values(#{entry_id},#{voter_id})")
    public void vote(VoteVO voteVO);
    @Delete("delete from vote_of_game where entry_id=#{entry_id} and voter_id=#{voter_id}")
    public void revokeVote(int entry_id,int voter_id);
}
