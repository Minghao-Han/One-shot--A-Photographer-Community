package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    public List<String> getPreference(int user_id);
    public void addPreference(String tag,int user_id);
    public void addPreferences(List<String> tags,int user_id);
    public void removePreference(String tag,int user_id);
    public void addTagsToShot(List<String> tags,int shot_id);
}
