package com.example.smarthomecoreserviceintegration.rpc;

import com.example.ssodemo.interceptor.LoginContext;
import com.example.ssodemo.model.UserDetailModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/21 11:28
 */
public interface LoginServiceIntegration {
    void logout(HttpServletResponse response);
    LoginContext getContext();
    void setNewToken(UserDetailModel user, HttpServletRequest request, HttpServletResponse response);

}
