package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.Utils.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void isExist() {
        User testUser = new User("韩明昊", Gender.Male,20,"hahahahaha");
        testUser.setId(4);
        System.out.println(userMapper.isExist(testUser));
    }
}