package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.TemporaryDataStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheStorageImpl implements TemporaryDataStoreService {
    private Map<String,Object> dataMap = new HashMap<>();
    @Override
    public void put(String key, Object value, Long expire_time) {
        dataMap.put(key, value);
        expireData(key, expire_time);
    }

    @Override
    public Object get(String key) {
        return dataMap.get(key);
    }
    @Scheduled(initialDelay = 5*60*1000)
    private void expireData(String key,Long expire_time){
        dataMap.remove(key);
    }
}
