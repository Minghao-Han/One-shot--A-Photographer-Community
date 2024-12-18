package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.VO.GameParticipatorVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameParticipationMapper {
    @Select("select * from game_participation where game_id = game_id")
    public List<GameParticipatorVO> getAllEntriesOfGame(int game_id);
    @Insert("insert into game_participation(game_id,user_id) values(#{game_id},#{user_id})")
    public void participate(GameParticipatorVO gameParticipatorVO);
    @Delete("delete from game_participation where game_id=#{game_id} and user_id=#{participator_id}")
    public void retire(int game_id,int participator_id);
    @Select("select count(*) from game_participation where game_id=#{game_id} and user_id=#{participator_id}")
    public boolean participated(int game_id,int participator_id);
    @Select("select count(*) from game_participation where id=#{entry_id}")
    public boolean entryExist(int entry_id);
    @Select("select game_id from game_participation where id = #{id}")
    public Integer getGameId(int id);
    @Update("update game_participation set total_votes = total_votes+1 where id = #{entry_id}")
    public void addTotalVotes(int entry_id);
    @Update("update game_participation set total_votes = total_votes-1 where id = #{entry_id}")
    public void subTotalVotes(int entry_id);
}
