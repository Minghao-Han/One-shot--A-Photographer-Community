package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Subscribe;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubscribeMapper {
    @Insert("insert into subscribe(user_id,subscribed_id) values(#{user_id},#{subscribed_id})")
    public void subscribe(int user_id,int subscribed_id);
    @Delete("delete from subscribe where user_id = #{user_id} and subscribed_id = #{subscribed_id}")
    public void cancelSubscribe(int user_id,int subscribed_id);
    @Select("select count(*) from subscribe where user_id = #{user_id} and subscribed_id = #{subscribed_id}")
    public boolean isExist(int user_id,int subscribed_id);
    @Select("select * from subscribe where user_id = #{user_id}")
    public List<Subscribe> getSubscription(int user_id);
    @Select("select count(*) from subscribe where user_id = #{user_id}")
    public Integer getSubscriptionNum(int user_id);
    @Select("select user_id from subscribe where subscribed_id = #{user_id}")
    public List<Integer> getFansId(int user_id);
    @Select("select count(*) from subscribe where subscribed_id = #{user_id}")
    public int getFanciesNum(int user_id);
}
