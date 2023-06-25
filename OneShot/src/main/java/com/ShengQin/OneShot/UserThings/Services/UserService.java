package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.User;

import java.util.List;

public interface UserService {
    public User getUser(int user_id);
    public void saveUser(User user);
    public List<String> getPreference(int user_id);
    public String getUserName(int user_id);
}
