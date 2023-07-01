package com.ShengQin.OneShot.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class TokenInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = request.getHeader("token");
        String requestUrl = request.getServletPath();
        if (token!=null){
            boolean result;
            // 验证token,user和admin用不同的验证方式
            if (requestUrl.contains("admin")) result = TokenUtil.checkAdminToken(token);
            else {
                result = TokenUtil.checkToken(token);
                request.setAttribute("user_id", TokenUtil.getUserIdFromToken(token));//从token获取用户id并放入request
            }
            if (result){
                System.out.println("通过拦截器："+requestUrl);  // 可以输出接口是否通过拦截器
                return true;
            }
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json=new JSONObject();
            json.put("msg","token认证失败");
            json.put("code","500");
            response.getWriter().append(json.toString());
            System.out.println("认证失败，未通过拦截器："+requestUrl);
        } catch (Exception e) {
            return false;
        }
        /**
         * 还可以在此处检验其他操作
         */
        return false;
    }
}

