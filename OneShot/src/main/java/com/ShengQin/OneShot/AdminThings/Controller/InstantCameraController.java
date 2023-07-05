package com.ShengQin.OneShot.AdminThings.Controller;

import com.ShengQin.OneShot.AdminThings.Mapper.InstantCameraMapper;
import com.ShengQin.OneShot.AdminThings.Service.InstantCameraService;
import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.AdminThings.Mapper.DigitalCameraMapper;
import com.ShengQin.OneShot.AdminThings.Service.DigitalCameraService;
import com.ShengQin.OneShot.Entities.InstantCamera;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping("/admin/instantcamera")
// http://localhost:9090/admin/instantcamera/page?pageNum=1&pageSize=5
public class InstantCameraController {

    @Autowired
    InstantCameraMapper instantCameraMapper;

    @Autowired
    InstantCameraService instantCameraService;

    @PostMapping("/addorupdate")
    public Integer save(@RequestBody InstantCamera instantCamera)
    {
        return instantCameraService.save(instantCamera);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable int id) {
        return instantCameraMapper.deleteById(id);
    }

    @GetMapping("/select")
    public List<InstantCamera> selectAll() {
        List<InstantCamera> all = instantCameraMapper.findAll();

        return all;
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        //pageNum = (pageNum - 1) * pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<InstantCamera> data = instantCameraMapper.findAll();//,email);
        Integer total = instantCameraMapper.selectTotal();//email);
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
        List<InstantCamera> data= instantCameraMapper.selectPage1(id);
        Integer total = instantCameraMapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
