package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("select tag from user_preference where user_id =#{user_id}")
    public List<String> getPreference(int user_id);
    @Select("select count(*) from user_preference where tag=#{tag} and user_id=#{user_id}")
    public boolean preferenceExist(String tag,int user_id);
    @Insert("insert into user_preference(user_id,tag) values(#{user_id},#{tag}")
    public void addPreference(@Param("tag") String tag,@Param("user_id") int user_id);
    @Insert("<script>insert into user_preference(user_id,tag) values"
            +"<foreach collection='tags' item ='tag' separator=','>"
            +"(#{user_id},#{tag})"
            +"</foreach></script>"
    )
    public void addPreferences(@Param("tags")List<String> tags,@Param("user_id")int user_id);
    @Delete("delete from user_preference where tag=#{tag} and user_id=#{user_id}")
    public void removePreference(@Param("tag")String tag,@Param("user_id")int user_id);
    @Insert("<script>insert into shot_tags(shot_id,tag) values"
            +"<foreach collection='tags' item ='tag' separator=','>"+
            "(#{shot_id},#{tag})"+
            "</foreach></script>"
    )
    public void addTagsToShot(@Param("tags")List<String> tags,@Param("shot_id")int shot_id);
    @Delete("delete from shot_tags where shot_id = #{shot_id}")
    public void removeTagsFromShot(int shot_id);
}
