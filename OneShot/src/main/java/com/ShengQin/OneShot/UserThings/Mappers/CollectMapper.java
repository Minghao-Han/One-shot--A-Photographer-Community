package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectMapper {
    /**shot*/
    public void shotAddCollect(int collector_id, int shot_id);
    public boolean shotCollectionExist(int collector_id, int shot_id);
    public void shotCancelCollect(int collector_id, int shot_id);
    /**post*/
    public void postAddCollect(int collector_id, int shot_id);
    public boolean postCollectionExist(int collector_id, int shot_id);
    public void postCancelCollect(int collector_id, int shot_id);
}
