package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.DigitalCameraMapper;
import com.ShengQin.OneShot.AdminThings.Mapper.InstantCameraMapper;
import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.Entities.InstantCamera;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstantCameraService {
    @Autowired
    InstantCameraMapper instantCameraMapper;

    public int save(InstantCamera instantCamera) {
        //Optional<Integer> idOptional = Optional.ofNullable(user.getId());
        if (!instantCameraMapper.isExist1(instantCamera.getId())) {
            System.out.println("111");
            return  instantCameraMapper.insert(instantCamera);
        } else {
            System.out.println("222");
            return   instantCameraMapper.update(instantCamera);
        }
    }
}
