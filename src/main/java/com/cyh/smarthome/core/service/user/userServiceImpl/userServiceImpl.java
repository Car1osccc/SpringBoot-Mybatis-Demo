package com.cyh.smarthome.core.service.user.userServiceImpl;

import com.cyh.smarthome.dal.user.mapper.UserMapper;
import com.cyh.smarthome.dal.user.model.User;
import com.cyh.smarthome.core.service.user.userService;
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

    public User selectUserByUserName(String UserName, String UserPassword){
        return userMapper.selectUserByUserName(UserName,UserPassword);
    }

    @Override
    public User selectUserByUserID(String UserID) {
        return userMapper.selectUserById(UserID);
    }
}