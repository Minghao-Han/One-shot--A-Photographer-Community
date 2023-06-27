package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShotCommentMapper {

    @Insert("insert into comment_of_shot(inner_id,shot_id,parent_id,commentator_id,content) values(#{innerID},#{shot_id},#{parent_id},#{commentator_id},#{content})")
    public void insert(Comment comment);

    @Delete("delete from comment_of_shot where shot_id=#{shot_id} and inner_id=#{innerID}")
    public void delete(int shot_id,int innerID);

    @Select("select count(*) from comment_of_shot where shot_id=#{shot_id} and inner_id=#{innerID}")
    public boolean isExist(int shot_id,int innerID);

    @Select("select max(inner_id)+1 from comment_of_shot group by shot_id having shot_id=#{shot_id}")
    public int getNewInnerID(int shot_id);
}
