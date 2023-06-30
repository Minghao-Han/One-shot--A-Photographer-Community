package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Post;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select * from post where id = #{post_id}")
    @Results(id="postMap", value={
            @Result(column="id", property="id", id=true),
            @Result(column="user_id", property="user_id"),
            @Result(column="title", property="title"),
            @Result(column="content", property="content"),
            @Result(column="total_thumb", property="total_thumb"),
            @Result(column="total_collect", property="total_collect"),
            @Result(column="page_view", property="pageView"),
            @Result(column="time", property="createTime", jdbcType= JdbcType.TIMESTAMP, javaType = java.util.Date.class)
    })
    public Post getPost(int post_id);

    public default void save(Post post){
        if (isExist(post)) {
            update(post);
        }
        else insert(post);
    }
    @Select("select count(*) from post where id=#{post_id}")
    public boolean idExist(int post_id);
    @Select("select count(*) from post where id=#{id}")
    public boolean isExist(Post post);

    public default Integer insert(Post newPost){
        insert1(newPost);
        return getLastInsertId();
    }

    @Insert("insert into post(user_id,title,content,total_thumb,total_collect,page_view,time) values(#{user_id},#{title},#{content},#{total_thumb},#{total_collect},#{pageView},#{createTime})")
    public void insert1(Post newPost);

    @Select("select max(id) from post")
    public int getLastInsertId();

    @Update("update post set title=#{title},content=#{content},total_thumb=#{total_thumb},total_collect=#{total_collect},page_view=#{pageView},time=#{createTime} where id=#{id}")
    public void update(Post updatedPost);
    @Delete("delete from post where id=#{post_id}")
    public void delete(int post_id);
    public List<Post> getRecommendPost(int pageNum);
    public List<Post> getPostsOf(int user_id, int pageNum);
}
