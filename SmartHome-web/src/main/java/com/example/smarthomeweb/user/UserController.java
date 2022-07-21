package com.example.smarthomeweb.user;

import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecommonutil.enums.RegisterStatusEnum;
import com.example.smarthomecoreservice.user.UserService;
import com.example.smarthomecoreserviceintegration.rpc.LoginServiceIntegration;
import com.example.smarthomeweb.ApiResult;
import com.example.smarthomeweb.user.mapping.UserMapping;
import com.example.smarthomeweb.user.request.UserLoginRequest;
import com.example.smarthomeweb.user.request.UserRegisterRequest;
import com.example.ssodemo.interceptor.LoginContext;
import com.example.ssodemo.model.UserDetailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yihan Chen
 * @date 2022/7/5 15:50
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
    public ApiResult userLogin(@RequestBody UserLoginRequest user,HttpServletResponse response) {
        UserDO userDO = userService.checkByUserNameAndPwd(user.getUserName(), user.getUserPassword());
        if (userDO == null) {
            log.error("用户名:{}, 密码:{}配对错误", user.getUserName(), user.getUserPassword());
            return ApiResult.error("用户名密码配对错误");
        } else {
            LoginContext loginContext = UserMapping.convert(userDO);
            loginServiceIntegration.login(loginContext, response);
            return ApiResult.ok();
        }
    }

    @RequestMapping("/getInfo")
    public ApiResult<UserDetailModel> getUserInfo(HttpServletRequest request) {
        Integer userID = LoginContext.getContext().getUserID();
        UserDO userDO = userService.selectUserByUserID(userID);
        UserDetailModel user = UserMapping.convert1(userDO);
        return ApiResult.ok(user);
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


    @RequestMapping("/modifyInfo")
    public ApiResult modifyInfo(@RequestBody UserRegisterRequest user) {
        UserDO userDO = new UserDO();
        userDO.setUserID(LoginContext.getContext().getUserID());
        userDO.setUserName(user.getUserName());
        userDO.setUserPassword(user.getUserPassword());
        userDO.setUserAddress(user.getUserAddress());
        userDO.setUserGender(user.getUserGender());
        userDO.setUserTelephone(user.getUserTelephone());
        if (userService.update(userDO)) {
            return ApiResult.ok();
        }
        return ApiResult.error("手机号不符合规范");
    }

    @RequestMapping("/test")
    public LoginContext test() {
        return LoginContext.getContext();
    }

}
