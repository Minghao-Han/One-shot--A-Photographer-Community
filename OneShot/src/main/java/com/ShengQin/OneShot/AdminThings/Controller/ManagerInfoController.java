package com.ShengQin.OneShot.AdminThings.Controller;

import com.ShengQin.OneShot.AdminThings.Mapper.ManagerMapper;
import com.ShengQin.OneShot.AdminThings.Service.ManagerService;
import com.ShengQin.OneShot.Entities.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/personinfo")
public class ManagerInfoController {


    //均为managerinfo操作相关对象
    @Autowired
    ManagerMapper managermapper;

    @Autowired
    private ManagerService managerservice;

    //用于对内容的增加与修改
    @PostMapping("/addorupdate")
    public Integer save(@RequestBody User mi){
        return managerservice.save(mi);
    }

    //查询所有用户
    @GetMapping("/select")
    public List<User> index() {
        List<User> all=managermapper.findAll();
        return all;
    }

    //分页查询
    @GetMapping("/pagem")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        pageNum=(pageNum-1)*pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<User> data= managermapper.findAll();
        Integer total = managermapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        System.out.println(data);
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable Integer id)
    {
        return  managermapper.deleteById(id);
    }

    //搜索2023/6/30
    @GetMapping("/searchdemo")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                        @RequestParam int id) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> data= managermapper.selectPage1(id);
        Integer total = managermapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

}
