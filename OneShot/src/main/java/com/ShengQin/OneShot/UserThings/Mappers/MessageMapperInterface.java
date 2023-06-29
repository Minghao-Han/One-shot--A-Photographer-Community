package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**------------获得未读/历史点赞或收藏----------*/

public interface MessageMapperInterface {
    public List<Map<String,Object>> getUncheckThumbMessage(int user_id);
    public List<Map<String,Object>> getUncheckCommentMessage(int user_id);
    public void checkThumbMessage(List<Integer> ids);
    public void checkCommentMessage(List<Integer> ids);
    public List<Map<String,Object>> getHistoryThumbMessage(int user_id);
    public List<Map<String,Object>> getHistoryCollectMessage(int user_id);
}
