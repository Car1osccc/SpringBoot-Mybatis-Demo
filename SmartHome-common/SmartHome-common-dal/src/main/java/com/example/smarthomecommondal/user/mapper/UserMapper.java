package com.example.smarthomecommondal.user.mapper;

import com.example.smarthomecommondal.user.model.UserDO;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:54
 */
public interface UserMapper {

    UserDO selectUserByUserName(String userName);
    UserDO selectUserById(String UserID);
    void register(UserDO user);

}
