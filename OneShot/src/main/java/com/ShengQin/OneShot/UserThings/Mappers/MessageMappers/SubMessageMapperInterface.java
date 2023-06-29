package com.ShengQin.OneShot.UserThings.Mappers.MessageMappers;

import java.util.List;
import java.util.Map;


/**------------获得未读/历史点赞或收藏----------*/

public interface SubMessageMapperInterface {//从各个点赞/收藏以及其他具体消息内容表如thumb_of_shot获取数据
    public Map<String,Object> getMessage(int references_id);
}
