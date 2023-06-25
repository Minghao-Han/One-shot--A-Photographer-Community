package com.ShengQin.OneShot.UserThings.Services;


import com.ShengQin.OneShot.Entities.User;

public interface RegisterService {
    public boolean register(String email, String password, User newUser);

}
