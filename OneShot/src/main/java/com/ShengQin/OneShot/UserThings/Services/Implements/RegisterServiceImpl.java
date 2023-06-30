package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Account;
import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Mappers.AccountMapper;
import com.ShengQin.OneShot.UserThings.Mappers.UserMapper;
import com.ShengQin.OneShot.UserThings.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(String email, String password, User newUser) {
        Account newAccount = new Account(email,password);
        if (accountMapper.emailExist(newAccount)) return false;
        accountMapper.insert(new Account(email,password));
        int id = accountMapper.getId(email);
        newUser.setId(id);
        userMapper.insert(newUser);
        return true;
    }
}
