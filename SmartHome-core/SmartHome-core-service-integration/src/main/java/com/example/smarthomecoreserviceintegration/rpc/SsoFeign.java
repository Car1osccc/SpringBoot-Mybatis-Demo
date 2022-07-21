package com.example.smarthomecoreserviceintegration.rpc;

import com.example.smarthomecoreserviceintegration.rpc.Configuration.FeignConfig;
import com.example.ssodemo.interceptor.LoginContext;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yihan Chen
 * @date 2022/7/27 14:02
 */
@FeignClient(value = "sso-service", configuration = FeignConfig.class)
public interface SsoFeign {

    /**
     * 通过Feign调用SSO模块根据用户信息生成Token
     * @param userID 用户ID
     * @param familyID 家庭ID
     * @param userName 用户名
     * @return token
     */
    @RequestMapping("/sso/generateToken")
    String generateToken(@RequestParam Integer userID,
                         @RequestParam Integer familyID,
                         @RequestParam String userName);

    /**
     * 调用SSO模块解析Request中Token包含的的用户信息
     * @return LoginContext 用户信息
     */
    @RequestMapping("/sso/getInfo")
    LoginContext getInfo();

}
