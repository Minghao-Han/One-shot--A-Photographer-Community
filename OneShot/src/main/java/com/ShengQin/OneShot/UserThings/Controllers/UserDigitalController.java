package com.ShengQin.OneShot.UserThings.Controllers;


import com.ShengQin.OneShot.AdminThings.Mapper.DigitalCameraMapper;
import com.ShengQin.OneShot.AdminThings.Service.DigitalCameraService;
import com.ShengQin.OneShot.Entities.Commentadmin;
import com.ShengQin.OneShot.Entities.DigitalCamera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:1206")
@RequestMapping("/camera")
public class UserDigitalController {

    @Autowired
    DigitalCameraMapper digitalCameraMapper;

    @Autowired
    DigitalCameraService digitalCameraService;

    @GetMapping("/get")
    public List<DigitalCamera> findParam(@RequestParam String name)
    {
       List<DigitalCamera> list=digitalCameraMapper.findParam(name); //改一下
       return list;
    }
}
