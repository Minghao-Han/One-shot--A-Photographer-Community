package com.ShengQin.OneShot.AdminThings.Mapper;



import com.ShengQin.OneShot.Entities.GameInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminGameInfoMapper {

    @Insert("INSERT INTO game_publish(id, title,content,start_time,end_time,winner,is_selected ) VALUES " +
            "(#{id},  #{title}, " +
            "#{content}, #{start_time},#{end_time},#{winner},#{isSelected})")
    Integer insert(GameInfo gameInfo);

    @Update("UPDATE game_publish set id = #{id}, title = #{title} ,content = #{content}," +
<<<<<<< HEAD
            "start_time = #{start_time}, end_time = #{end_time} ,winner = #{winner},is_selected=#{isSelected}where id= #{id}")
=======
            "start_time = #{start_time}, end_time = #{end_time} ,winner = #{winner}where id= #{id}")
>>>>>>> af3b9df8c8dff0f131d86ce72048d585e670db5c
    Integer update(GameInfo gameInfo);

    @Select("select count(*) from game_publish where id=#{id}")
    boolean isExist(int id);

    @Select("select * from game_publish")
    @Results(id="game_publish", value={
            @Result(column="id", property="id", id=true),
            @Result(column="title", property="title"),
            @Result(column="content", property="content"),

            @Result(column="start_time", property="start_time"),
            @Result(column="end_time", property="end_time"),
            @Result(column="winner", property="winner"),
            @Result(column="is_selected", property="isSelected")
    })
    List<GameInfo> findAll();


    @Select("SELECT * from  game_publish  limit #{pageNum},  #{pageSize}")
    @Results(id="game_publish1", value={
            @Result(column="id", property="id", id=true),
            @Result(column="title", property="title"),
            @Result(column="content", property="content"),
            @Result(column="start_time", property="start_time"),
            @Result(column="end_time", property="end_time"),
            @Result(column="winner", property="winner"),
            @Result(column="is_selected", property="isSelected")
    })
    List<GameInfo> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from game_publish")
    Integer selectTotal();

    @Delete("delete from game_publish where id =#{id}")
    Integer deleteByShotId(int id);

    @Select("SELECT count(*)  from game_publish where id=#{id}")
    Integer selectTotal1(Integer id);

    @Select("SELECT  * from  game_publish where id like CONCAT('%', #{id}, '%')")
    List<GameInfo> selectPage1(Integer id);
}
