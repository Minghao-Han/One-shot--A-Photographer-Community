package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.ManagerMapper;
import com.ShengQin.OneShot.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    public int save(User user) {
        //Optional<Integer> idOptional = Optional.ofNullable(user.getId());
        if (!managerMapper.isExist1(user.getId())) {
            System.out.println("111");
            return  managerMapper.insert(user);
        } else {
            System.out.println("222");
            return   managerMapper.update(user);
        }
    }


}
