package com.ShengQin.OneShot.AdminThings.Controller;



import com.ShengQin.OneShot.AdminThings.Mapper.AdminUserMapper;
import com.ShengQin.OneShot.AdminThings.Service.AdminUserService;
import com.ShengQin.OneShot.Entities.Account;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController()
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserService adminUserService;

    //上传内容（”增“与”改“）
    @PostMapping("/user")
    public Integer save(@RequestBody Account account){
       // System.out.println(user);
        return adminUserService.save(account); //可以完成新增与更新
    }

//    //登录相关controller
//    @PostMapping("/login")
//    public User login(@RequestBody User user) {
//        String email = user.getEmail();
//        String password = user.getPassword();
//        System.out.println(email+" "+password);
//        User dbUser = usermapper.getUserByEmailAndPassword(email, password);
//        return dbUser;
//    }

    //查询所有用户
    @GetMapping("/")
    public List<Account> index() {
    List<Account> all= adminUserMapper.findAll();
    return all;
    }

    //分页查询,接口可以修改,返回页码和内容，用于显示在主界面中
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){//,
                                       // @RequestParam String email) {
//        pageNum=(pageNum-1)*pageSize;
        //email="%"+email+"%";
        PageHelper.startPage(pageNum,pageSize);
       List<Account> data= adminUserMapper.findAll();//,email);
       Integer total = adminUserMapper.selectTotal();//email);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //搜索测试
    @GetMapping("/searchdemo")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
            @RequestParam String email) {
        PageHelper.startPage(pageNum,pageSize);
        List<Account> data= adminUserMapper.selectPage1(email);
        Integer total = adminUserMapper.selectTotal1(email);
       // email="%"+email+"%";

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //删除
    @DeleteMapping("/{email}")
    public Integer delete(@PathVariable String email)
    {
       return  adminUserMapper.deleteByEmail(email);
    }

    @PostMapping("/delbatch")
    public boolean deleteBatch(@RequestBody List<String> emails){
        return adminUserService.removeByEmails(emails);
    }

    //批量删除
//    @DeleteMapping("/batch/{id}")
//    public boolean deleteBatch(@RequestBody List<Integer> ids){
//        return userService.removeByIds(ids);
//    }
}