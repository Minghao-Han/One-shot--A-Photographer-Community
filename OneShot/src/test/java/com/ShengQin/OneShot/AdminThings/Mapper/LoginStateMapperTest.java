package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.LogInState;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoginStateMapperTest {
@Autowired
LoginStateMapper loginStateMapper;
    @Test
    void findAll() {
        List<LogInState> logInStateList = loginStateMapper.findAll();
        for (LogInState logInState:logInStateList
             ) {
            System.out.println(logInState);
        }
    }
}