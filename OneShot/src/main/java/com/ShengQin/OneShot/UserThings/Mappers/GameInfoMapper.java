package com.ShengQin.OneShot.UserThings.Mappers;


import com.ShengQin.OneShot.Entities.GameInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface GameInfoMapper {

    @Select("select * from game_publish where end_time>(select CURRENT_TIMESTAMP) and start_time<(select CURRENT_TIMESTAMP)")
    @Results(id="gameMap", value={
            @Result(column="start_time", property="start_time", jdbcType= JdbcType.TIMESTAMP, javaType = java.util.Date.class),
            @Result(column="end_time", property="end_time", jdbcType= JdbcType.TIMESTAMP, javaType = java.util.Date.class)
    })
    public List<GameInfo> getOngoingGame();

    @Select("select * from game_publish where end_time<(select CURRENT_TIMESTAMP)")
    @ResultMap("gameMap")
    public List<GameInfo> getHistoryGame();
    @Select("select * from game_publish where id=#{game_id}")
    @ResultMap("gameMap")
    public GameInfo getGame(int game_id);
    @Select("select count(*) from game_publish where id=#{game_id}")
    public boolean gameExist(int game_id);}
