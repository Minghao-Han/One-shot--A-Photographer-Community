package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SubscribeMapper {
    @Insert("insert into subscribe(user_id,subscribed_id) values(#{user_id},#{subscribed_id})")
    public void subscribe(int user_id,int subscribed_id);
    @Delete("delete from subscribe where user_id = #{user_id} and subscribed_id = #{subscribed_id}")
    public void cancelSubscribe(int user_id,int subscribed_id);
    @Select("select count(*) from subscribe where user_id = #{user_id} and subscribed_id = #{subscribed_id}")
    public boolean isExist(int user_id,int subscribed_id);
}
