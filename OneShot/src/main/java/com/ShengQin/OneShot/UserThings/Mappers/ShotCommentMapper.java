package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShotCommentMapper {

    @Insert("insert into comment_of_shot(inner_id,shot_id,parent_id,commentator_id,content) values(#{innerID},#{shotId},#{parentId},#{commentatorId},#{content}")
    @SelectKey(statement = "SELECT last_insert_id()", keyProperty = "id", before = false, resultType = int.class)
    public void insert(Comment comment);

    @Delete("delete from comment_of_shot where shot_id=#{shotId} and inner_id=#{innerID}")
    public void delete1(int shot_id,int innerID);
    @Select("select id from comment_of_shot where shot_id=#{shotId} and inner_id=#{innerID}")
    public int getId(int shot_id,int innerID);
    public default int delete(int shot_id, int innerID){
        int id = getId(shot_id, innerID);
        delete1(shot_id, innerID);
        return id;
    }

    @Select("select count(*) from comment_of_shot where shot_id=#{shotId} and inner_id=#{innerID}")
    public boolean isExist(int shot_id,int innerID);

    @Select("select max(inner_id)+1 from comment_of_shot group by shot_id having shot_id=#{shotId}")
    public Integer getNewInnerID(int shot_id);
    @Select("select * from comment_of_shot where shot_id=#{shotId}")
    public List<Comment> getComment(int shot_id);
}
