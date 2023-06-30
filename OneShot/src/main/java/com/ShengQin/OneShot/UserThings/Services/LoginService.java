package com.ShengQin.OneShot.UserThings.Services;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public boolean verify (String email,String password);
    public int getId(String email);
}
