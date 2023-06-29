package com.ShengQin.OneShot.UserThings.Services.SubMessageServices;


import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.Message;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSubMessageService {
    @Autowired
    UserService userService;

    public abstract Message getMessage(int references_id);
}
