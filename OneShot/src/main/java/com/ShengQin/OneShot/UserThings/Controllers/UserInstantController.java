package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.AdminThings.Mapper.DigitalCameraMapper;
import com.ShengQin.OneShot.AdminThings.Mapper.InstantCameraMapper;
import com.ShengQin.OneShot.AdminThings.Service.DigitalCameraService;
import com.ShengQin.OneShot.AdminThings.Service.InstantCameraService;
import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.Entities.InstantCamera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:1206")
@RequestMapping("/instantcamera")
public class UserInstantController {
    @Autowired
    InstantCameraMapper instantCameraMapper;

    @Autowired
    InstantCameraService instantCameraService;

    @GetMapping("/get")
    public List<InstantCamera> findParam(@RequestParam String name)
    {
        List<InstantCamera> list=instantCameraMapper.findParam(name); //改一下
        for (InstantCamera instantCamera:list) {
            System.out.println(instantCamera);
        }
        return list;
    }
}
