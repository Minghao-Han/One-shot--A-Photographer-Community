package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    public default void save(User user) {
        if (isExist(user)) update(user);
        else insert(user);
    }
    @Select("select count(*) from user where id=#{id}")
    public boolean isExist(User user);

    @Update("update user set user_name=#{userName},personal_signature=#{personalSignature},gender=#{gender},age=#{age} where id=#{id}")
    public void update(User updatedUser);
    @Insert("insert into user values (#{id},#{userName},#{personalSignature},#{gender},#{age})")
    public void insert(User newUser);
}
