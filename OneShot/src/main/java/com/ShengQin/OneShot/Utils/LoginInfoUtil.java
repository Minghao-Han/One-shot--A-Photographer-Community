package com.ShengQin.OneShot.Utils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginInfoUtil {
    public Map<String,Object> getLoginInfo(HttpServletRequest request){
        Map<String,Object> loginInfo = new HashMap<>();
        String ip = request.getHeader("x-forwarded-for");
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        if(ip.equals("0:0:0:0:0:0:0:1")){
            ip="127.0.0.1";
        }
        System.out.println("IP地址："+ip);
        loginInfo.put("ip_address",ip);
        String agentStr = request.getHeader("user-agent");//是一个包含浏览器信息，操作系统信息等所有信息等字符串
        System.out.println(agentStr);
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);//字符串转成UserAgent对象，方便提取信息
        loginInfo.put("userAgent",agent);
        //浏览器
        Browser browser = agent.getBrowser();
        loginInfo.put("browser",browser);
        System.out.println("类型："+browser.getBrowserType()+
                "\n名称："+browser.getName()+
                "\n厂商："+browser.getManufacturer()+
                "\n产品系列："+browser.getGroup()+
                "\n引擎："+browser.getRenderingEngine());

        //浏览器版本
        Version version = agent.getBrowserVersion();
        loginInfo.put("browser_version",version);
        if (version!=null){
            System.out.println("========================");
            System.out.println("主版本："+version.getMajorVersion()+
                    "\n小版本："+version.getMinorVersion()+
                    "\n完整版本："+version.getVersion());
        }else {
            System.out.println("========================");
            System.out.println("未知版本");
        }
        //操作系统
        System.out.println("========================");
        OperatingSystem os = agent.getOperatingSystem();
        loginInfo.put("operating_system",os);
        if (os!=null){
            System.out.println("名称："+os.getName()+
                    "\n设备类型："+os.getDeviceType()+
                    "\n产品系列："+os.getGroup()+
                    "\n生成厂商："+os.getManufacturer());
        }else {
            System.out.println("未知操作系统");
        }
        return loginInfo;
    }
}
