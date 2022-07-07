package com.example.demo.service.user.userServiceImpl;

import com.example.demo.dal.user.mapper.UserMapper;
import com.example.demo.dal.user.model.User;
import com.example.demo.service.user.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/6 10:50
 */

@Service
public class userServiceImpl implements userService {

    @Resource
    private UserMapper userMapper;

    public User info(String UserName, String UserPassword){
        return userMapper.info(UserName,UserPassword);
    }
}