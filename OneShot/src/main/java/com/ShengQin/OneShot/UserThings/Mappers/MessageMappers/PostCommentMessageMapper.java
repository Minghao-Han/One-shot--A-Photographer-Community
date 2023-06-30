package com.ShengQin.OneShot.UserThings.Mappers.MessageMappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostCommentMessageMapper extends SubMessageMapperInterface {
    @Override
    @Select("select id,post_id,content,commentator_id from comment_of_post where id = #{references_id}")
    public Map<String,Object> getMessage(int references_id);
}
