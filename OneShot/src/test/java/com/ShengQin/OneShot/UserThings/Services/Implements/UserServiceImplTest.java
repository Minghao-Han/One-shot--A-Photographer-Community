package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void getUser() {
        User user = userService.getUser(4);
        System.out.println(user);
    }

    @Test
    void getUserName() {
        System.out.println(userService.getUserName(5));
    }
}