package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ThumbMapper {
    /**shot*/
    @Insert("insert into thumb_of_shot(shot_id,thumber_id)  values(#{shot_id},#{thumber_id})")
    public void shotAddThumb(int thumber_id, int shot_id);

    @Select("select count(*) from thumb_of_shot where shot_id=#{shot_id} and thumber_id=#{thumber_id}")
    public boolean shotThumbExist(int thumber_id,int shot_id);
    @Delete("delete from thumb_of_shot where shot_id=#{shot_id} and thumber_id=#{thumber_id}")
    public void shotCancelThumb(int thumber_id,int shot_id);
    /**post*/
    @Insert("insert into thumb_of_post(post_id,thumber_id) values(#{post_id},#{thumber_id})")
    public void postAddThumb(int thumber_id,int post_id);
    @Select("select count(*) from thumb_of_post where shot_id=#{post_id} and thumber_id=#{thumber_id}")
    public boolean postThumbExist(int thumber_id,int post_id);
    @Delete("delete from thumb_of_post where shot_id=#{post_id} and thumber_id=#{thumber_id}")
    public void postCancelThumb(int thumber_id,int post_id);
}
