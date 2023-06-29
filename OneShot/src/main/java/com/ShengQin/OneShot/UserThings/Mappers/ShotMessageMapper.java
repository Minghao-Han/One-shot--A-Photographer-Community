package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShotMessageMapper{
    @Select("select * from thumb_of_shot where is_read = false and shot_id in (select id from shot where user_id =#{user_id} order by time desc)")
    List<Map<String, Object>> getUncheckThumbMessage(int user_id);

    @Select("select * from comment_of_shot where is_read = false and receiver_id = #{user_id} order by time desc")
    List<Map<String, Object>> getUncheckCommentMessage(int user_id);

    @Select("select * from thumb_of_shot where shot_id in (select id from shot where user_id =#{user_id} order by time desc)")
    List<Map<String, Object>> getHistoryThumbMessage(int user_id);

    @Select("select * from comment_of_shot receiver_id = #{user_id} order by time desc")
    List<Map<String, Object>> getHistoryCollectMessage(int user_id);

    @Update("<script>update thumb_of_shot set is_read = true where" +
            "<foreach collection='ids' item ='id' separator='or'>" +
            "id=#{id}" +
            "</foreach></script>"
    )
    void checkThumbMessage(List<Integer> ids);

    @Update("<script>update comment_of_shot set is_read = true where" +
            "<foreach collection='ids' item ='id' separator='or'>" +
            "id=#{id}" +
            "</foreach></script>"
    )
    void checkCommentMessage(List<Integer> ids);
}
