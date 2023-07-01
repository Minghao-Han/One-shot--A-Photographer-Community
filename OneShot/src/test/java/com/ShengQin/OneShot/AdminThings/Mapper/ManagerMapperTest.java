package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerMapperTest {
    @Autowired
    ManagerMapper managerMapper;

    @Test
    void selectPage() {
        List<User> users = managerMapper.selectPage(1,6);
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    void findAll() {
        List<User> users = managerMapper.findAll();
        for (User user :
                users) {
            System.out.println(user);
        }
    }
}