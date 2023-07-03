package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExistService {
    @Autowired
    UserMapper userMapper;
    public boolean userExist(int user_id){
        return userMapper.isExistById(user_id);
    }
}
