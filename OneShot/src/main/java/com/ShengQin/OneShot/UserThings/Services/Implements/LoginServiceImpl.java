package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.AccountMapper;
import com.ShengQin.OneShot.UserThings.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public boolean verify(String email,String password) {
        String shouldBePassword = accountMapper.getPassword(email);
        if (password.equals(shouldBePassword)) return true;
        else return false;
    }

    @Override
    public int getId(String email) {
        return accountMapper.getId(email);
    }
}

