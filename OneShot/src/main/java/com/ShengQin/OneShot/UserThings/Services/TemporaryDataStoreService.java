package com.ShengQin.OneShot.UserThings.Services;

public interface TemporaryDataStoreService {
    public void put(String key,Object value,Long expire_time);
    public Object get(String key);
}
