package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.AdminThings.Mapper.DigitalCameraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DigitalCameraService {
    @Autowired
    DigitalCameraMapper digitalCameraMapper;

    public int save(DigitalCamera digitalCamera) {
        //Optional<Integer> idOptional = Optional.ofNullable(user.getId());
        if (!digitalCameraMapper.isExist1(digitalCamera.getId())) {
            System.out.println("111");
            return  digitalCameraMapper.insert(digitalCamera);
        } else {
            System.out.println("222");
            return   digitalCameraMapper.update(digitalCamera);
        }
    }
}
