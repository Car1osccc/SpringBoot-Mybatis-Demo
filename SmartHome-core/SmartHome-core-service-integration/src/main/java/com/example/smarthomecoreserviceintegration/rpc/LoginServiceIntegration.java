package com.example.smarthomecoreserviceintegration.rpc;

import com.example.ssodemo.interceptor.LoginContext;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yihan Chen
 * @date 2022/7/21 11:28
 */
public interface LoginServiceIntegration {

    /**
     * 从ThreadLocal中获取LoginContext
     * @param token TOKEN
     * @return LoginContext
     */
    LoginContext getContextFromToken(String token);

    /**
     * 通过用户信息以及当前时间创造新的Token并写入Cookie
     * @param context 用户信息
     * @param request 请求
     * @param response 响应
     */
    void login(LoginContext context, HttpServletResponse response);

    /**
     * 调用SsoFeign得到用户信息
     * @return 用户信息
     */
    LoginContext getInfo();

    /**
     * 调用Sso生成Token
     * @param loginContext 用户信息
     * @return Token
     */
    String generateToken(LoginContext loginContext);

}
