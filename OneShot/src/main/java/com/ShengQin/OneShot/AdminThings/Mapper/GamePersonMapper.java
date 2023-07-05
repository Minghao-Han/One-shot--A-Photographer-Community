package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.GameInfo;
import com.ShengQin.OneShot.Entities.GamePerson;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GamePersonMapper {
    @Insert("INSERT INTO game_participation(id, game_id,user_id,total_votes,time ) VALUES " +
            "(#{id},  #{game_id}, " +
            "#{user_id}, #{total_votes},#{time})")
    Integer insert(GamePerson gamePerson);

    @Update("UPDATE game_participation set id = #{id}, game_id = #{game_id} ,user_id = #{user_id}," +
            "total_votes = #{total_votes}, time = #{time} where id= #{id}")
    Integer update(GamePerson gamePerson);

    @Select("select count(*) from game_participation where id=#{id}")
    boolean isExist(int id);

    @Select("select * from game_participation")
    @Results(id="game_particition", value={
            @Result(column="id", property="id", id=true),
            @Result(column="game_id", property="game_id"),
            @Result(column="user_id", property="user_id"),

            @Result(column="total_votes", property="total_votes"),
            @Result(column="time", property="time")
    })
    List<GamePerson> findAll();


    @Select("SELECT * from  game_participation  limit #{pageNum},  #{pageSize}")
    @Results(id="game_participation1", value={
            @Result(column="id", property="id", id=true),
            @Result(column="game_id", property="game_id"),
            @Result(column="user_id", property="user_id"),
            @Result(column="total_votes", property="total_votes"),
            @Result(column="time", property="time")
    })
    List<GamePerson> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from game_participation")
    Integer selectTotal();

    @Delete("delete from game_participation where id =#{id}")
    Integer deleteById(int id);

    @Select("SELECT count(*)  from game_participation where id=#{id}")
    Integer selectTotal1(Integer id);

    @Select("SELECT  * from  game_participation where id like CONCAT('%', #{id}, '%')")
    List<GamePerson> selectPage1(Integer id);

}
