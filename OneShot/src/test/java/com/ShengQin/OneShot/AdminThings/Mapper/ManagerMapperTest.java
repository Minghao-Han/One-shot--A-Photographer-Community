package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagerMapperTest {
    @Autowired
    ManagerMapper managerMapper;

    @Test
    void selectPage() {
        List<User> users = managerMapper.selectPage(1,3);
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    void findAll() {
        List<User> users = managerMapper.selectPage();
        for (User user :
                users) {
            System.out.println(user);
        }
    }

}