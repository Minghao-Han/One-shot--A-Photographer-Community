package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.*;

@Mapper
public interface ThumbMapper {
    /**shot*/

    @Select("select max(id) from thumb_of_shot")
    public Integer getLatestInsertShotThumbId();
    @Insert("insert into thumb_of_shot(shot_id,thumber_id)  values(#{shot_id},#{thumber_id})")
    @SelectKey(statement="SELECT last_insert_id() from thumb_of_shot", keyProperty="id", keyColumn = "id",before=true, resultType=Long.class)
    public Long shotAddThumb1(int thumber_id, int shot_id);
    public default Integer shotAddThumb(int thumber_id, int shot_id){
        shotAddThumb1(thumber_id,shot_id);
        return getLatestInsertShotThumbId();
    }

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
