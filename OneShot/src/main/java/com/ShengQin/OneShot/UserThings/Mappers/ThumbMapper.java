package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Thumb;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ThumbMapper {
    /**shot*/


    @Insert("insert into thumb_of_shot(shot_id,thumber_id)  values(#{work_id},#{thumber_id})")
    @SelectKey(statement = "SELECT last_insert_id()", keyProperty = "id",keyColumn = "id" ,before = false, resultType = int.class)
    public int shotAddThumb(Thumb newThumb);

    @Select("select count(*) from thumb_of_shot where shot_id=#{shot_id} and thumber_id=#{thumber_id}")
    public boolean shotThumbExist(int thumber_id,int shot_id);
    @Select("select id from thumb_of_shot where shot_id=#{shot_id} and thumber_id=#{thumber_id}")
    public int getShotThumbId(int thumber_id,int shot_id);
    public default int shotCancelThumb(int thumber_id,int shot_id){
        int id = getShotThumbId(thumber_id,shot_id);
        shotCancelThumb1(thumber_id, shot_id);
        return id;
    }
    @Delete("delete from thumb_of_shot where shot_id=#{shot_id} and thumber_id=#{thumber_id}")
    public void shotCancelThumb1(int thumber_id,int shot_id);
    /**post*/
    @Insert("insert into thumb_of_post(post_id,thumber_id) values(#{post_id},#{thumber_id})")
    public void postAddThumb(Thumb newThumb);
    @Select("select count(*) from thumb_of_post where shot_id=#{post_id} and thumber_id=#{thumber_id}")
    public boolean postThumbExist(int thumber_id,int post_id);
    @Select("select id from thumb_of_post where shot_id=#{post_id} and thumber_id=#{thumber_id}")
    public int getPostThumbId(int thumber_id,int post_id);
    @Delete("delete from thumb_of_post where shot_id=#{post_id} and thumber_id=#{thumber_id}")
    public void postCancelThumb1(int thumber_id,int post_id);
    public default int postCancelThumb(int thumber_id,int post_id){
        int id = getPostThumbId(thumber_id,post_id);
        postCancelThumb1(thumber_id, post_id);
        return id;
    }
}
