package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeMapper {
    public void subscribe(int user_id,int subscribed_id);
    public void cancelSubscribe(int user_id,int subscribed_id);
}
