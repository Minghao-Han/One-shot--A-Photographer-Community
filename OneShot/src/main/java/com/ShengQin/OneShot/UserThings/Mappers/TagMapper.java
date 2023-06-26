package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    public List<String> getPreference(int user_id);
    public void addPreference(@Param("tag") String tag,@Param("user_id") int user_id);
    public void addPreferences(@Param("tag")List<String> tags,@Param("user_id")int user_id);
    public void removePreference(@Param("tag")String tag,@Param("user_id")int user_id);
    @Insert("<script>insert into shot_tags values"
            +"<foreach collection='tags' item ='tag' separator=','>"+
            "(#{shot_id},#{tag})"+
            "</foreach></script>"
    )
    public void addTagsToShot(@Param("tags")List<String> tags,@Param("shot_id")int shot_id);
    @Delete("delete from shot_tags where shot_id = #{shot_id}")
    public void removeTagsFromShot(int shot_id);
}
