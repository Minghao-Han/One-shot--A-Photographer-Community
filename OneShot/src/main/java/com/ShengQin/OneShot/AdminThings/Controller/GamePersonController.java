package com.ShengQin.OneShot.AdminThings.Controller;

import com.ShengQin.OneShot.AdminThings.Mapper.GamePersonMapper;
import com.ShengQin.OneShot.AdminThings.Mapper.ManagerMapper;
import com.ShengQin.OneShot.AdminThings.Service.GamePersonService;

import com.ShengQin.OneShot.Entities.GamePerson;
import com.ShengQin.OneShot.Entities.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/admin/gameperson")
public class GamePersonController {


    //均为gameperson操作相关对象
    @Autowired
    GamePersonMapper gamePersonMapper;

    @Autowired
    private GamePersonService gamePersonService;

    //用于对内容的增加与修改
    @PostMapping("/addorupdate")
    public Integer save(@RequestBody GamePerson gamePerson){
        return gamePersonService.save(gamePerson);
    }

    //查询所有用户
    @GetMapping("/select")
    public List<GamePerson> index() {
        List<GamePerson> all=gamePersonMapper.findAll();
        return all;
    }

    //分页查询
    @GetMapping("/pagem")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        pageNum=(pageNum-1)*pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<GamePerson> data= gamePersonMapper.findAll();
        Integer total = gamePersonMapper.selectTotal();
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
        return  gamePersonMapper.deleteById(id);
    }

    //搜索2023/6/30
    @GetMapping("/searchdemo")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                        @RequestParam int id) {
        PageHelper.startPage(pageNum,pageSize);
        List<GamePerson> data= gamePersonMapper.selectPage1(id);
        Integer total = gamePersonMapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

}
