package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.LoginLogMapper;
import com.ShengQin.OneShot.UserThings.Services.LoginLogService;
import com.ShengQin.OneShot.Utils.LoginInfoUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    LoginInfoUtil loginInfoUtil;
    @Autowired
    LoginLogMapper loginLogMapper;
    @Override
    public void logLoginInfo(HttpServletRequest request,int user_id) {
        Map<String,Object> loginInfo = loginInfoUtil.getLoginInfo(request);
        UserAgent userAgent = (UserAgent) loginInfo.get("userAgent");
        OperatingSystem operating_system = (OperatingSystem) loginInfo.get("operating_system");
        String os_name = operating_system!=null?operating_system.getName():null;
        Version browser_version = (Version) loginInfo.get("browser_version");
        Browser browser = (Browser) loginInfo.get("browser");
        String browserName = browser!=null? browser.getName() : null;
        String ip_address = (String) loginInfo.get("ip_address");
        loginLogMapper.log(user_id,"登录成功",ip_address, operating_system.getName(), browser.getName(),new Date(),null);
    }
}
