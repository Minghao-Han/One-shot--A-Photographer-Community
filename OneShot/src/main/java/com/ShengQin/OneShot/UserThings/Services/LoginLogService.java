package com.ShengQin.OneShot.UserThings.Services;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginLogService {
    public void logLoginInfo(HttpServletRequest request,int user_id);
}
