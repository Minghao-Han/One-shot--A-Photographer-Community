package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Shot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShotMapper {
    public Shot getShotWithTags(int shot_id);
    public Shot getShot(int shot_id);
    public default void save(Shot shot){
        if (isExist(shot)) {
            update(shot);
        }
        else insert(shot);
    }
    public boolean isExist(int user_id);
    public boolean isExist(Shot shot);
    public void insert(Shot newShot);
    public void update(Shot updatedShot);
    public List<Shot> getRecommendShot(List<String> tags,int pageNum);//多条件查询
    public List<Shot> getShotsOf(int user_id, int pageNum);

}
