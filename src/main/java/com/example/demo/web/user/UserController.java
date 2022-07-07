package com.example.demo.web.user;

import com.example.demo.dal.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:50
 */

@RestController
public class UserController {

    @Autowired
    private com.example.demo.service.user.userService userService;

    @PostMapping("/api/loginCheck")
    public String GetUser(@RequestBody User user) {
        User myUser = userService.info(user.getUserName(),user.getUserPassword());
        if (myUser == null) {
            return "/error";
        } else
            return myUser.toString();
    }

    @PostMapping("/register")
    public String UserRegister(@RequestParam("UserID") String UserID) {
        return "REGISTER";
    }
}
