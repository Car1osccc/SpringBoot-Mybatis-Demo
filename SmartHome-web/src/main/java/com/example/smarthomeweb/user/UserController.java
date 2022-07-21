package com.example.smarthomeweb.user;

import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecommonutil.enums.RegisterStatusEnum;
import com.example.smarthomecoreservice.user.UserService;
import com.example.smarthomecoreserviceintegration.rpc.LoginServiceIntegration;
import com.example.smarthomeweb.user.mapping.UserMapping;
import com.example.smarthomeweb.user.request.UserRegisterRequest;
import com.example.ssodemo.interceptor.LoginContext;
import com.example.ssodemo.model.UserDetailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:50
 */
@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private LoginServiceIntegration loginServiceIntegration;

    @PostMapping("/loginCheck")
    public UserDetailModel userLogin(@RequestParam String userName, @RequestParam String userPassword, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDO userDO = userService.checkByUserNameAndPwd(userName, userPassword);
        if (userDO == null) {
            return null;
        } else {
            UserDetailModel user = UserMapping.convert(userDO);
            loginServiceIntegration.setNewToken(user, request, response);
            return user;
        }
    }
    @RequestMapping("/logout")
    public void logout(HttpServletResponse response){
        loginServiceIntegration.logout(response);
    }


    @PostMapping("/register")
    public String userRegister(@RequestBody UserRegisterRequest user) {
        Integer registerStatus = userService.userRegister(UserMapping.convert(user));
        if (registerStatus == RegisterStatusEnum.TELEPHONE_INVALID.ordinal()) {
            return "输入电话号码格式有误，请重新输入";
        } else if (registerStatus == RegisterStatusEnum.USERNAME_INVALID.ordinal()) {
            return "该用户名已存在，请重新输入";
        }
        return "注册成功！现在为您返回登陆界面";
    }

    @RequestMapping("/findPassword")
    public String findPassword(@RequestParam String userName, @RequestParam String userTelephone) {
        if (userService.selectUserByUserNameAndTel(userName, userTelephone) == null) {
            return "你输入的用户名或手机号有误，请重新输入";
        } else {
            return "请更改密码";
        }
    }

    @RequestMapping("/test")
    public LoginContext test() {
        return loginServiceIntegration.getContext();
    }
}
