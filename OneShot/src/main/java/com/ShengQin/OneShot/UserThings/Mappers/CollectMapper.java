package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    /**shot*/
    @Insert("insert into collect_of_shot(collector_id,shot_id) values(#{collector_id},#{shot_id})")
    public void shotAddCollect(int collector_id, int shot_id);
    @Select("select count(*) from collect_of_shot where collector_id = #{collector_id} and shot_id = #{shot_id}")
    public boolean shotCollectionExist(int collector_id, int shot_id);
    @Delete("delete from collect_of_shot where collector_id = #{collector_id} and shot_id = #{shot_id}")
    public void shotCancelCollect(int collector_id, int shot_id);
    @Select("select shot_id from collect_of_shot where collector_id = #{collector_id}")
    public List<Integer> getCollectedShotId(int user_id);
    /**post*/
    @Insert("insert into collect_of_post (collector_id,post_id) values(#{collector_id},#{post_id})")
    public void postAddCollect(int collector_id, int post_id);
    @Select("select count(*) from collect_of_post where collector_id = #{collector_id} and post_id = #{post_id}")
    public boolean postCollectionExist(int collector_id, int post_id);
    @Delete("delete from collect_of_post where collector_id = #{collector_id} and post_id = #{post_id}")
    public void postCancelCollect(int collector_id, int post_id);
}
