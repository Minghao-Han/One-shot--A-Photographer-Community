package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountMapperTest {
    @Autowired
    AccountMapper accountMapper;

    @Test
    void getAccount() {
        System.out.println(accountMapper.getAccount(4));
    }

    @Test
    void save() {
        Account account = new Account(5,"3117824612@qq.com","11223344");
        accountMapper.save(account);
    }

    @Test
    void getId() {
        System.out.println(accountMapper.getId("1907821839@qq.com"));
    }
}