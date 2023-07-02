package com.ShengQin.OneShot.AdminThings.Mapper;
import com.ShengQin.OneShot.Entities.Account;
import com.ShengQin.OneShot.Entities.Shotadmin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShotadminMapper {

    //不知道为什么数据没有全部返回，明天找bug

    @Select("SELECT * FROM shot")
    @Results(id="shotMap", value={
            @Result(column="id", property="id", id=true),
            @Result(column="user_id", property="user_id"),
            @Result(column="title", property="title"),
            @Result(column="content", property="content"),
            @Result(column="total_thumb", property="total_thumb"),
            @Result(column="total_collect", property="total_collect"),
            @Result(column="page_view", property="page_view"),
            @Result(column="time", property="time")
    })
    List<Shotadmin> findAll();

    @Insert("INSERT INTO shot(id, user_id,title,content,total_thumb,total_collect,page_view,time ) VALUES " +
            "(#{id}, #{user_id}, #{title}, " +
            "#{content}, #{total_thumb},#{total_collect},#{page_view},#{time})")
    int insert(Shotadmin shotadmin);




    @Select("SELECT * from  shot  limit #{pageNum},  #{pageSize}")
    @Results(id="shotMap1", value={
            @Result(column="id", property="id", id=true),
            @Result(column="user_id", property="user_id"),
            @Result(column="title", property="title"),
            @Result(column="content", property="content"),
            @Result(column="total_thumb", property="total_thumb"),
            @Result(column="total_collect", property="total_collect"),
            @Result(column="page_view", property="page_view"),
            @Result(column="time", property="time")
    })
    List<Shotadmin> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT count(*)  from shot ")
    Integer selectTotal();

    //删除
    @Delete("delete from shot where id= #{id}")
    int  deleteByShotId(@Param("id") Integer id);

    @Update("UPDATE shot set id = #{id}, user_id = #{user_id},title=#{title},content=#{content}," +
            " total_thumb=#{total_thumb} where id= #{id}")
    int update(Shotadmin shotadmin);

    @Select("select count(*) from shot where id = #{id}")
    public boolean isExist1(Integer id);


    @Select("SELECT  * from  shot where id like CONCAT('%', #{id}, '%')")
    List<Shotadmin> selectPage1(int id);

    @Select("SELECT count(*)  from shot  where  id=#{id}")
    Integer selectTotal1(int id);
}
