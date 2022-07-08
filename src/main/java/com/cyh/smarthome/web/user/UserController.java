package com.cyh.smarthome.web.user;

import com.alibaba.fastjson.JSON;
import com.cyh.smarthome.core.service.family.FamilyService;
import com.cyh.smarthome.core.service.user.UserService;
import com.cyh.smarthome.dal.user.model.User;
import com.cyh.smarthome.web.user.model.userLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:50
 */
@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/api/loginCheck")
    public String getUser(@RequestBody userLoginVO userLogin) {
        User myUser = userService.selectUserByUserName(userLogin.getUserName(),userLogin.getUserPassword());
        if (myUser == null) {
            return "/error";
        } else
            return JSON.toJSONString(myUser);
    }

    @PostMapping("/api/register")
    public void userRegister(@RequestBody User user) {
        userService.userRegister(user);
    }
}
