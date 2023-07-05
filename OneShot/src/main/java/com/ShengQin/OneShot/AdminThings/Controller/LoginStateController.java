package com.ShengQin.OneShot.AdminThings.Controller;

import com.ShengQin.OneShot.AdminThings.Mapper.LoginStateMapper;
import com.ShengQin.OneShot.AdminThings.Service.LoginStateService;
import com.ShengQin.OneShot.Entities.LogInState;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/admin/LogState")
public class LoginStateController {
    //均为managerinfo操作相关对象
    @Autowired
    LoginStateMapper loginStateMapper;

    @Autowired
    private LoginStateService loginStateService;

    //用于对内容的增加与修改
    @PostMapping("/addorupdate")
    public Integer save(@RequestBody LogInState logInState){
        return loginStateService.save(logInState);
    }

    //查询所有用户
    @GetMapping("/select")
    public List<LogInState> index() {
        List<LogInState> all=loginStateMapper.findAll();
        return all;
    }

    //分页查询
    @GetMapping("/pagem")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        pageNum=(pageNum-1)*pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<LogInState> data= loginStateMapper.findAll();


        Integer total = loginStateMapper.selectTotal();
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
        return  loginStateMapper.deleteById(id);
    }

    //搜索2023/6/30
    @GetMapping("/searchdemo")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                        @RequestParam int id) {
        PageHelper.startPage(pageNum,pageSize);
        List<LogInState> data= loginStateMapper.selectPage1(id);

        Integer total = loginStateMapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //通过日期搜索2023/7/4
    @GetMapping("/searchOnlyByDate")
    public Map<String,Object> findPage1(@RequestParam Integer pageNum,@RequestParam Integer pageSize,
                                        @RequestParam String logdate){
        PageHelper.startPage(pageNum,pageSize);
        List<LogInState> data=loginStateMapper.selectPage2(logdate);
        Integer total=loginStateMapper.selectTotal2(logdate);

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
