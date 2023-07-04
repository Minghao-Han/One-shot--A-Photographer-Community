package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.TemporaryDataStoreService;
import com.ShengQin.OneShot.Utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisStorageImpl implements TemporaryDataStoreService {
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void put(String key, Object value, Long expire_time) {
        System.out.println("using redis to store");
        if (value instanceof String) redisUtil.set(key,(String) value,expire_time, TimeUnit.MILLISECONDS);
        else {
            String serializedValue = redisUtil.serializeObject(value);
            redisUtil.set(key, serializedValue, expire_time, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public Object get(String key) {
        Object obj = redisUtil.get(key);
        if (obj==null) return null;
        String serializedValue = (String) obj;
        if (serializedValue instanceof String ) return serializedValue;
        else return redisUtil.deserializeObject(serializedValue);
    }
}
