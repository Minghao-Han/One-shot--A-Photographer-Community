package com.ShengQin.OneShot.Services.Implements;

import com.ShengQin.OneShot.Mappers.AccountMapper;
import com.ShengQin.OneShot.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public boolean varify() {
        return true;
    }
}
