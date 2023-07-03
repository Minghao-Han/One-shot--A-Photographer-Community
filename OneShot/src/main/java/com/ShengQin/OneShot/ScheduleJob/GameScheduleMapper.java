package com.ShengQin.OneShot.ScheduleJob;

import com.ShengQin.OneShot.Entities.GameInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface GameScheduleMapper {
    @Select("select * from game_publish where end_time<(select CURRENT_TIMESTAMP) and is_selected=false")
    @Results(id="gameMap2", value={
            @Result(column="start_time", property="start_time", jdbcType= JdbcType.TIMESTAMP, javaType = java.util.Date.class),
            @Result(column="end_time", property="end_time", jdbcType= JdbcType.TIMESTAMP, javaType = java.util.Date.class)
    })
    public List<GameInfo> getFinishedNoWinnerGames();//找结束但没winner的比赛


    @Select("select * from game_publish where end_time>=(select CURRENT_TIMESTAMP) order by end_time")
    @ResultMap("gameMap2")
    public List<GameInfo> getUnfinishedGames();//找未结束比赛（可以未开始）
    @Select("select user_id from game_participation where game_id=#{game_id} and total_votes!=0 and total_votes >= " +
            "(select max(total_votes) from game_participation group by game_id having game_id=#{game_id})" +
            " order by time desc")
    public List<Integer> selectWinner1(int game_id);

    public default Integer selectWinner(int game_id){
        List<Integer> winners_id = selectWinner1(game_id);
        if (winners_id.isEmpty()) return null;
        else return winners_id.get(0);
    }

    @Update("update game_publish set winner = #{winner_id},is_selected=true where id=#{game_id}")
    public void setWinner(int winner_id,int game_id);
}
