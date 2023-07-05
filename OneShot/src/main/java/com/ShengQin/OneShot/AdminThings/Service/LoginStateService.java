package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.LoginStateMapper;


import com.ShengQin.OneShot.Entities.LogInState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginStateService {
    @Autowired
    LoginStateMapper loginStateMapper;

    public int save(LogInState logInState) {
        //Optional<Integer> idOptional = Optional.ofNullable(user.getId());
        if (!loginStateMapper.isExist1(logInState.getUserID())) {
            System.out.println("111");
            return  loginStateMapper.insert(logInState);
        } else {
            System.out.println("222");
            return   loginStateMapper.update(logInState);
        }
    }
}
