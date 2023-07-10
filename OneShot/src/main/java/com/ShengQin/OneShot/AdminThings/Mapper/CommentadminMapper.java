package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.Account;
import com.ShengQin.OneShot.Entities.Commentadmin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentadminMapper {


    @Select("SELECT * FROM comment_of_shot")
    @Results(id="comment_of_shotMap", value={
            @Result(column="id", property="id", id=true),
            @Result(column="inner_id", property="inner_id"),
            @Result(column="shot_id", property="shot_id"),
            @Result(column="parent_id", property="parent_id"),
            @Result(column="commentator_id", property="commentator_id"),
            @Result(column="content", property="content"),
            @Result(column="time", property="time"),
            @Result(column="receiver_id", property="receiver_id")
    })
    List<Commentadmin> findAll();

    @Delete("delete from comment_of_shot where id= #{id}")
    Integer deleteById(int id);



    @Select("SELECT * from  comment_of_shot  limit #{pageNum},  #{pageSize}")
    @Results(id="comment_of_shotMap1", value={
            @Result(column="id", property="id", id=true),
            @Result(column="inner_id", property="inner_id"),
            @Result(column="shot_id", property="shot_id"),
            @Result(column="parent_id", property="parent_id"),
            @Result(column="commentator_id", property="commentator_id"),
            @Result(column="content", property="content"),
            @Result(column="time", property="time"),
            @Result(column="receiver_id", property="receiver_id")
    })
    List<Commentadmin> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT count(*)  from comment_of_shot ")
    Integer selectTotal();


    List<Commentadmin> selectPage1(Integer pageNum, Integer pageSize, Integer id);

    @Select("SELECT count(*)  from comment_of_shot where id=#{id}")
    Integer selectTotal1(Integer id);

    @Select("SELECT  * from  comment_of_shot where id like CONCAT('%', #{id}, '%')")
    List<Commentadmin> selectPage1(Integer id);

    @Select("select count(*) from comment_of_shot where id = #{id}")
    boolean isExist1(int id);

    @Insert("INSERT INTO comment_of_shot(id, inner_id,shot_id,parent_id,commentator_id,content,time" +
            ",receiver_id) VALUES (#{id}, #{inner_id},#{shot_id},#{parent_id},#{commentator_id}," +
            "#{content},#{time},#{receiver_id})")
    int insert(Commentadmin commentadmin);

    @Update("UPDATE comment_of_shot set id = #{id}, inner_id = #{inner_id},shot_id=#{shot_id},parent_id=#{parent_id}," +
            " commentator_id=#{commentator_id}, content = #{content}, time = #{time}" +
            ", receiver_id = #{receiver_id} where id= #{id}")
    int update(Commentadmin commentadmin);
}
