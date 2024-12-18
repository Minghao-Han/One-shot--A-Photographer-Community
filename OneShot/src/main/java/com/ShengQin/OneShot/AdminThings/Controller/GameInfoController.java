package com.ShengQin.OneShot.AdminThings.Controller;


import com.ShengQin.OneShot.AdminThings.Mapper.AdminGameInfoMapper;
import com.ShengQin.OneShot.AdminThings.Service.GameInfoService;
import com.ShengQin.OneShot.Entities.GameInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/admin/gamepublish")
public class GameInfoController {
@Autowired
AdminGameInfoMapper adminGameInfoMapper;

@Autowired
GameInfoService gameInfoService;

@PostMapping("/addorupdate")
    public Integer save(@RequestBody GameInfo gameInfo)
{
    return gameInfoService.save(gameInfo);
}

//获取所有比赛信息
    @GetMapping("/select")
    public List<GameInfo> index() {
        List<GameInfo> all= adminGameInfoMapper.findAll();
        return all;
    }

    //分页查询比赛信息
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        //pageNum=(pageNum-1)*pageSize;

        PageHelper.startPage(pageNum,pageSize);
        List<GameInfo> data= adminGameInfoMapper.findAll();
        Integer total = adminGameInfoMapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //删除比赛信息
    @DeleteMapping("delete/{id}")
    public Integer delete(@PathVariable int id)
    {
        return  adminGameInfoMapper.deleteByShotId(id);
    }

    //6.30
    //搜索测试
    @GetMapping("/searchdemo")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                        @RequestParam int id) {
        pageNum=(pageNum-1)*pageSize;
        List<GameInfo> data= adminGameInfoMapper.selectPage1(id);
        Integer total = adminGameInfoMapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
