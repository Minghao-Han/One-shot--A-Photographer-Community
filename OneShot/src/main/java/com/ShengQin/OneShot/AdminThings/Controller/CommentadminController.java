package com.ShengQin.OneShot.AdminThings.Controller;


import com.ShengQin.OneShot.AdminThings.Mapper.CommentadminMapper;
import com.ShengQin.OneShot.AdminThings.Service.CommentadminService;
import com.ShengQin.OneShot.Entities.Commentadmin;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/admin/CommentAdmin")
public class CommentadminController {
    @Autowired
    CommentadminMapper commentadminMapper;

    @Autowired
    private CommentadminService commentadminService;
    //增与改
    //改主要是对不好的内容可以写不予显示？

    @PostMapping("/addorupdate")
    public Integer save(@RequestBody Commentadmin commentadmin) {
        return commentadminService.save(commentadmin);

    }


    //删

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable int id) {
        return commentadminMapper.deleteById(id);
    }


    //查

    //1.查全部
    @GetMapping("/select")
    public List<Commentadmin> selectAll() {
        List<Commentadmin> all = commentadminMapper.findAll();

        return all;
    }

    //2.分页查
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        //pageNum = (pageNum - 1) * pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<Commentadmin> data = commentadminMapper.findAll();//,email);
        Integer total = commentadminMapper.selectTotal();//email);
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
        List<Commentadmin> data= commentadminMapper.selectPage1(id);
        Integer total = commentadminMapper.selectTotal1(id);
        // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}