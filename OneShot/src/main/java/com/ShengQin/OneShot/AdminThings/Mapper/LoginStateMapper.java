package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.LogInState;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoginStateMapper {
    @Select("SELECT * FROM sys_log")
    @Results(id="log1", value={
            @Result(column="logID", property="logID", id=true),
            @Result(column="userID", property="userID"),
            @Result(column="Log_Content", property="Log_Content"),
            @Result(column="IP_Address", property="IP_Address"),
            @Result(column="OS", property="OS"),
            @Result(column="IE", property="IE"),
            @Result(column="CreateDate", property="CreateDate"),
            @Result(column="Remark", property="Remark")
    })
    List<LogInState> findAll();

    @Insert("INSERT INTO sys_log(logID, userID,Log_Content,IP_Address,OS,IE,CreateDate,Remark ) VALUES " +
            "(#{logID}, #{userID}, #{Log_Content}, " +
            "#{IP_Address}, #{OS},#{IE},#{CreateDate},#{Remark })")
    int insert(LogInState logInState);




    @Select("SELECT * from  sys_log  limit #{pageNum},  #{pageSize}")
    @Results(id="log2", value={
            @Result(column="logID", property="logID", id=true),
            @Result(column="userID", property="userID"),
            @Result(column="Log_Content", property="Log_Content"),
            @Result(column="IP_Address", property="IP_Address"),
            @Result(column="OS", property="OS"),
            @Result(column="IE", property="IE"),
            @Result(column="CreateDate", property="CreateDate"),
            @Result(column="Remark", property="Remark")
    })
    List<LogInState> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT count(*)  from sys_log ")
    Integer selectTotal();

    //删除
    @Delete("delete from sys_log where logID= #{logID}")
    int  deleteById(@Param("logID") Integer logID);

    @Update("UPDATE sys_log set logID = #{logID}, userID = #{userID},Log_Content=#{Log_Content},IP_Address=#{IP_Address}," +
            " OS=#{OS} , IE=#{IE} , CreateDate=#{CreateDate} ,Remark=#{Remark}where logID= #{logID}")
    int update(LogInState logInState);

    @Select("select count(*) from sys_log where logID = #{logID}")
    public boolean isExist1(Integer logID);


    @Select("SELECT  * from  sys_log where logID like CONCAT('%', #{logID}, '%')")
    List<LogInState> selectPage1(int logID);

    @Select("SELECT count(*)  from sys_log  where  logID=#{logID}")
    Integer selectTotal1(int logID);

    @Select("SELECT  * from  sys_log where CreateDate like CONCAT('%', #{CreateDate}, '%')")
    @Results(id="log3", value={
            @Result(column="logID", property="logID", id=true),
            @Result(column="userID", property="userID"),
            @Result(column="Log_Content", property="Log_Content"),
            @Result(column="IP_Address", property="IP_Address"),
            @Result(column="OS", property="OS"),
            @Result(column="IE", property="IE"),
            @Result(column="CreateDate", property="CreateDate"),
            @Result(column="Remark", property="Remark")
    })
    List<LogInState> selectPage2(String CreateDate);



    @Select("SELECT count(*)  from sys_log  where  CreateDate like CONCAT('%', #{CreateDate}, '%')")
    Integer selectTotal2(String CreateDate);
}