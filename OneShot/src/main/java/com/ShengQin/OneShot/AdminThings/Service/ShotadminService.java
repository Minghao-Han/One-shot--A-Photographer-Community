package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.ShotadminMapper;
import com.ShengQin.OneShot.Entities.Shotadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShotadminService {
    @Autowired
    ShotadminMapper shotadminMapper;

    public int save(Shotadmin shotadmin) {
        //Optional<Integer> idOptional = Optional.ofNullable(user.getId());
        if (!shotadminMapper.isExist1(shotadmin.getId())) {
            System.out.println("111");
            return  shotadminMapper.insert(shotadmin);
        } else {
            System.out.println("222");
            return   shotadminMapper.update(shotadmin);
        }
    }


}
