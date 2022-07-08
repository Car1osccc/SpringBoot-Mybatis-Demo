package com.cyh.smarthome.dal.user.mapper;

import com.cyh.smarthome.dal.user.model.UserDO;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/5 15:54
 */
public interface UserMapper {

    UserDO selectUserByUserName(String userName, String userPassword);
    UserDO selectUserById(String UserID);
    void register(UserDO user);

}
