package com.example.smarthomeweb.user.Interceptor;

import com.example.smarthomecoreserviceintegration.rpc.LoginServiceIntegration;
import com.example.ssodemo.interceptor.LoginContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yihan Chen
 * @date 2022/7/27 16:04
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginServiceIntegration loginServiceIntegration;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从request中获取token解析用户信息
        LoginContext loginContext = loginServiceIntegration.getInfo();
        //若token解析失败则需要重新登录
        if (loginContext==null){
            response.sendRedirect("http://localhost");
        }else{
            //将用户信息存入ThreadLocal并刷新token
            LoginContext.setContext(loginContext);
            String newToken = loginServiceIntegration.generateToken(loginContext);
            Cookie cookie = new Cookie("userToken",newToken);
            cookie.setPath("/");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LoginContext.remove();
    }

}
