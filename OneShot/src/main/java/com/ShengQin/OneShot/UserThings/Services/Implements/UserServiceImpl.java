package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Mappers.UserMapper;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(int user_id) {
        return userMapper.getUser(user_id);
    }

    @Override
    public void saveUser(User user) {
        userMapper.save(user);
    }


    @Override
    public String getUserName(int user_id) {
        return userMapper.getUserName(user_id);
    }
}
