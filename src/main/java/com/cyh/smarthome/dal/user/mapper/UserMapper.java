package com.cyh.smarthome.dal.user.mapper;

import com.cyh.smarthome.dal.user.model.User;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:54
 */
public interface UserMapper {

    User selectUserByUserName(String UserName, String UserPassword);
    User selectUserById(String UserID);

}
