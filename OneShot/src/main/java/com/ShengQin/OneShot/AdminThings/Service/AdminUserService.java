package com.ShengQin.OneShot.AdminThings.Service;


import com.ShengQin.OneShot.AdminThings.Mapper.AdminUserMapper;
import com.ShengQin.OneShot.Entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserMapper userMapper;

    public boolean removeByEmails(List<String> emails) {
       return userMapper.removeByEmails(emails);
    }
    // private User user;

    //用于判断是否有id存在
    public int save(Account account) {
        Optional<Integer> idOptional = Optional.ofNullable(account.getId());
        if (!userMapper.isExist1(account.getEmail())) {
           System.out.println("111");
           return  userMapper.insert(account);
        } else {
            System.out.println("222");
          return   userMapper.update(account);
        }
    }


    //明天学mybatis-plus再弄
//    public boolean removeByIds(List<Integer> ids) {
//
//    }
}
