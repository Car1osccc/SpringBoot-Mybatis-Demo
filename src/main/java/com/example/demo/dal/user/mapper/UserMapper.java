package com.example.demo.dal.user.mapper;

import com.example.demo.dal.user.model.User;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:54
 */
public interface UserMapper {

    User info(String UserName, String UserPassword);

}
