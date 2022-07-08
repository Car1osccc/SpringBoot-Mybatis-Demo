package com.cyh.smarthome.web.user;

import com.alibaba.fastjson.JSON;
import com.cyh.smarthome.dal.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:50
 */

@RestController
public class UserController {

    @Autowired
    private com.cyh.smarthome.core.service.user.userService userService;

    @PostMapping("/api/loginCheck")
    public String GetUser(@RequestBody User user) {
        User myUser = userService.selectUserByUserName(user.getUserName(),user.getUserPassword());
        if (myUser == null) {
            return "/error";
        } else
            return JSON.toJSONString(myUser);
    }

    @PostMapping("/register")
    public String UserRegister(@RequestParam("UserID") String UserID) {
        return "REGISTER";
    }
}
