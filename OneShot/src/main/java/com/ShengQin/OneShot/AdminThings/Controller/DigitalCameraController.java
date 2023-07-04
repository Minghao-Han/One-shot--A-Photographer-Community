package com.ShengQin.OneShot.AdminThings.Controller;

import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.AdminThings.Mapper.DigitalCameraMapper;
import com.ShengQin.OneShot.AdminThings.Service.DigitalCameraService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping("/admin/camera")
public class DigitalCameraController {

@Autowired
    DigitalCameraMapper digitalCameraMapper;

@Autowired
    DigitalCameraService digitalCameraService;

@PostMapping("/addorupdate")
    public Integer save(@RequestBody DigitalCamera digitalCamera)
{
    return digitalCameraService.save(digitalCamera);
}

@DeleteMapping("/delete/{id}")
public Integer delete(@PathVariable int id) {
    return digitalCameraMapper.deleteById(id);
}

@GetMapping("/select")
public List<DigitalCamera> selectAll() {
    List<DigitalCamera> all = digitalCameraMapper.findAll();

    return all;
}

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        //pageNum = (pageNum - 1) * pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<DigitalCamera> data = digitalCameraMapper.findAll();//,email);
        Integer total = digitalCameraMapper.selectTotal();//email);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    //搜索2023/6/30
    @GetMapping("/searchdemo")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                        @RequestParam int id) {
        //  pageNum=(pageNum-1)*pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<DigitalCamera> data= digitalCameraMapper.selectPage1(id);
        Integer total = digitalCameraMapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
