package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostMessageMapper extends MessageMapperInterface{
    public List<Map<String,Object>> getUncheckThumbMessage(int user_id);
    public List<Map<String,Object>> getUncheckCommentMessage(int user_id);
    public void checkThumbMessage(List<Integer> ids);
    public void checkCommentMessage(List<Integer> ids);
    public List<Map<String,Object>> getHistoryThumbMessage(int user_id);
    public List<Map<String,Object>> getHistoryCollectMessage(int user_id);
}
