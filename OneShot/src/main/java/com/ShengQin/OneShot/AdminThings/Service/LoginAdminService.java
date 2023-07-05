package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.LoginAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAdminService {
    @Autowired
    LoginAdminMapper loginAdminMapper;
    public boolean verify(String email,String password){
        String shouldBePassword = loginAdminMapper.getPassword(email);
        if (password.equals(shouldBePassword)) return true;
        else return false;
    }
    public int getId(String email){
        return loginAdminMapper.getId(email);
    }
}
