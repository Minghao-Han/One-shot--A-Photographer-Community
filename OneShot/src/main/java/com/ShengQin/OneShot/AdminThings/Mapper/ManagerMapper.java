package com.ShengQin.OneShot.AdminThings.Mapper;


import com.ShengQin.OneShot.Entities.Account;
import com.ShengQin.OneShot.Entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerMapper {

    //插入与查找
    @Select("SELECT * FROM user")
    @Results(id="shotMap", value={
            @Result(column="id", property="id", id=true),
            @Result(column="user_name", property="userName"),
            @Result(column="personal_signature", property="personalSignature"),
            @Result(column="gender", property="gender"),
            @Result(column="age", property="age"),

    })
    List<User> findAll();

    @Insert("INSERT INTO user(user_name, id,gender,personal_signature,age ) VALUES (#{user_name}, #{id}, #{gender}, " +
            "#{personal_signature}, #{age})")
    int insert(User managerinfo);

//    @Select("SELECT * from  user  limit #{pageNum},  #{pageSize}")
//    @Select("SELECT * from  user")
//    @Results(id="shotMap1", value={
//            @Result(column="id", property="id", id=true),
//            @Result(column="user_name", property="userName"),
//            @Result(column="personal_signature", property="personalSignature"),
//            @Result(column="gender", property="gender"),
//            @Result(column="age", property="age"),
//
//    })
//    List<User> selectPage(Integer pageNum, Integer pageSize);

//    @Select("SELECT * FROM user")
//    List<User> abc();

    @Select("SELECT count(*)  from user  ")
    Integer selectTotal();

    //删除
    @Delete("delete from user where id= #{id}")
    int  deleteById(@Param("id") Integer id);

    @Update("UPDATE user set user_name = #{user_name}, id = #{id},gender=#{gender},personal_signature=#{personal_signature}," +
            " age=#{age} where id= #{id}")
    int update(User user);

    @Select("select count(*) from user where id = #{id}")
    public boolean isExist1(Integer id);

    @Select("SELECT  * from  user where id like CONCAT('%', #{id}, '%')")
    List<User> selectPage1(int id);

    @Select("SELECT count(*)  from account  where  id=#{id}")
    Integer selectTotal1(int id);
}
