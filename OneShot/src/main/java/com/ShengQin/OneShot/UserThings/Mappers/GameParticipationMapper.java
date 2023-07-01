package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.VO.GameParticipatorVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameParticipationMapper {
    @Insert("insert into game_participation(game_id,user_id) values(#{game_id},#{user_id})")
    public void participate(GameParticipatorVO gameParticipatorVO);
    @Delete("delete from game_participation where game_id=#{game_id} and user_id=#{user_id}")
    public void retire(int game_id,int participator_id);
    @Select("select count(*) from game_participation where game_id=#{game_id} and user_id=#{user_id}")
    public boolean participated(int game_id,int participator_id);
    @Select("select count(*) from game_participation where id=#{entry_id}")
    public boolean entryExist(int entry_id);
}
