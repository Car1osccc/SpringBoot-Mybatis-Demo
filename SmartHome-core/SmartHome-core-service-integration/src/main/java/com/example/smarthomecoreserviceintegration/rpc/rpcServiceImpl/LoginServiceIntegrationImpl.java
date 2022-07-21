package com.example.smarthomecoreserviceintegration.rpc.rpcServiceImpl;

import com.example.smarthomecoreserviceintegration.rpc.LoginServiceIntegration;
import com.example.ssodemo.controller.LoginController;
import com.example.ssodemo.interceptor.LoginContext;
import com.example.ssodemo.model.UserDetailModel;
import com.example.ssodemo.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/21 11:29
 */
@Service
public class LoginServiceIntegrationImpl implements LoginServiceIntegration {

    @Resource
    private LoginController loginController;

    @Resource
    private LoginService loginService;

    @Override
    public void logout(HttpServletResponse response) {
        loginService.logout(response);
    }

    @Override
    public LoginContext getContext() {
        return loginController.getInfoFromThreadLocal();
    }

    @Override
    public void setNewToken(UserDetailModel user, HttpServletRequest request, HttpServletResponse response) {
        loginService.setNewToken(user,request,response);
    }


}
