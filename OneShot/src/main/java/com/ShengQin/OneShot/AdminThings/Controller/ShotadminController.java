package com.ShengQin.OneShot.AdminThings.Controller;


import com.ShengQin.OneShot.AdminThings.Mapper.ShotadminMapper;
import com.ShengQin.OneShot.AdminThings.Service.ShotadminService;
import com.ShengQin.OneShot.Entities.Shotadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/ShotAdmin")
public class ShotadminController {
    @Autowired
    ShotadminMapper shotadminmapper;

    @Autowired
    private ShotadminService shotadminservice;

    //用于对内容的增加与修改
    @PostMapping("/add")
    public Integer save(@RequestBody Shotadmin sa){
        return shotadminmapper.insert(sa);
    }

    //查询所有shot
    @GetMapping("/select")
    public List<Shotadmin> index() {
        List<Shotadmin> all=shotadminmapper.findAll();
        return all;
    }

    //分页查询
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;

        List<Shotadmin> data= shotadminmapper.selectPage(pageNum,pageSize);
        Integer total = shotadminmapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable Integer id)
    {
        return  shotadminmapper.deleteByShotId(id);
    }

}
