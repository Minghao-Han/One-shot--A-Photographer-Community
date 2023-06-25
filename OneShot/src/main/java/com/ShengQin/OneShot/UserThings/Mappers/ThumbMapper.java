package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThumbMapper {
    /**shot*/
    public void addThumb(int thumber_id,int shot_id);
    public boolean shotThumbExist(int thumber_id,int shot_id);
    public void shotCancelThumb(int thumber_id,int shot_id);
    /**post*/
    public void postAddThumb(int thumber_id,int post_id);
    public boolean postThumbExist(int thumber_id,int post_id);
    public void postCancelThumb(int thumber_id,int post_id);
}
