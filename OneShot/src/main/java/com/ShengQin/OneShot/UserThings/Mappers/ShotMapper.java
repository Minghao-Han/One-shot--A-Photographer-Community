package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Shot;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShotMapper {
    public Shot getShotWithTags(int shot_id);
    @Select("select * from shot where id = #{shot_id}")
    @Results(id="shotMap", value={
            @Result(column="id", property="id", id=true),
            @Result(column="user_id", property="user_id"),
            @Result(column="title", property="title"),
            @Result(column="content", property="content"),
            @Result(column="total_thumb", property="total_thumb"),
            @Result(column="total_collect", property="total_collect"),
            @Result(column="page_view", property="pageView"),
            @Result(column="time", property="createTime", jdbcType= JdbcType.TIMESTAMP, javaType = java.util.Date.class)
    })
    public Shot getShot(int shot_id);

    public default void save(Shot shot){
        if (isExist(shot)) {
            update(shot);
        }
        else insert(shot);
    }
    @Select("select count(*) from shot where id=#{shot_id}")
    public boolean idExist(int shot_id);
    @Select("select count(*) from shot where id=#{id}")
    public boolean isExist(Shot shot);

    public default Integer insert(Shot newShot){
        insert1(newShot);
        return getLastInsertId();
    }

    @Insert("insert into shot(user_id,title,content,total_thumb,total_collect,page_view,time) values(#{user_id},#{title},#{content},#{total_thumb},#{total_collect},#{pageView},#{createTime})")
    public void insert1(Shot newShot);

    @Select("select max(id) from shot")
    public int getLastInsertId();

    @Update("update shot set title=#{title},content=#{content},total_thumb=#{total_thumb},total_collect=#{total_collect},page_view=#{pageView},time=#{createTime} where id=#{id}")
    public void update(Shot updatedShot);
    @Delete("delete from shot where id=#{shot_id}")
    public void delete(int shot_id);
    @Select("<script>select  from shot_tags where"
            +"<foreach collection='tags' item ='tag' separator='or'>"+
            "tag=#{tag}"+
            "</foreach></script>"
    )
    public int getShotMatchesPreferenceHighTotal(List<String> tags,int pageNum);//获得符合用户喜好且高浏览点赞比的shot总数
    public List<Integer> getShotMatchesPreferenceHigh(List<String> tags,int pageNum);//多条件查询,获得符合用户喜好且高浏览点赞比的shot
    public List<Integer> getShotMatchesPreferenceLow(List<String> tags,int pageNum);//多条件查询,获得符合用户喜好但低浏览点赞比的shot
    public int getShotIgnoresPreferenceHighTotal(int pageNum);//获得不匹配用户喜好，高浏览点赞比的shot总数
    public List<Integer> getShotIgnorePreferenceHigh(int pageNum);//多条件查询,不匹配用户喜好但高浏览点赞比的shot
    public List<Integer> getShotIgnorePreferenceLow(int pageNum);//多条件查询,不匹配用户喜好且低浏览点赞比的shot
    public List<Integer> getShotsOfUser(int user_id, int pageNum);

}
