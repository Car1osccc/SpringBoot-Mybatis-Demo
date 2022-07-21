package com.example.smarthomecoreserviceintegration.rpc.rpcServiceImpl;

import com.example.smarthomecoreserviceintegration.rpc.SsoFeign;
import com.example.smarthomecoreserviceintegration.rpc.LoginServiceIntegration;
import com.example.ssodemo.interceptor.LoginContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yihan Chen
 * @date 2022/7/21 11:29
 */
@Slf4j
@Service
public class LoginServiceIntegrationImpl implements LoginServiceIntegration {

    private final String url = "sso-service";

    @Autowired
    @Lazy
    private SsoFeign ssoFeign;

    @Override
    public LoginContext getContextFromToken(String token) {
        return LoginContext.getContext();
    }


    @Override
    public void login(LoginContext logincontext, HttpServletResponse response) {
        log.info("即将生成" + logincontext + "的Token");
        String newToken = ssoFeign.generateToken(logincontext.getUserID(), logincontext.getFamilyID(), logincontext.getUserName());
        log.info("Token为" + newToken);
        Cookie cookie = new Cookie("userToken", newToken);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
    }

    @Override
    public LoginContext getInfo() {
        return ssoFeign.getInfo();
    }

    @Override
    public String generateToken(LoginContext loginContext) {
        return ssoFeign.generateToken(loginContext.getUserID(), loginContext.getFamilyID(), loginContext.getUserName());
    }

}
