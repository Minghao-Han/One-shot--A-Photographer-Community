package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    public default void save(User user) {
        if (isExistBy(user)) update(user);
        else insert(user);
    }
    @Select("select count(*) from user where id=#{id}")
    public boolean isExistBy(User user);
    @Select("select count(*) from user where id=#{user_id}")
    public boolean isExistById(int user_id);

    @Update("update user set user_name=#{userName},personal_signature=#{personalSignature},gender=#{gender},age=#{age} where id=#{id}")
    public void update(User updatedUser);
    @Insert("insert into user values (#{id},#{userName},#{personalSignature},#{gender},#{age})")
    public void insert(User newUser);

    @Select("select * from user where id=#{user_id}")
    public User getUser(int user_id);
    @Select("select user_name from user where id=#{user_id}")
    public String getUserName(int user_id);
}
