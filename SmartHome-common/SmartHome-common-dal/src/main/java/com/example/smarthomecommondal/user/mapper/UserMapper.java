package com.example.smarthomecommondal.user.mapper;

import com.example.smarthomecommondal.user.model.UserDO;

/**
 * @author Yihan Chen
 * @date 2022/7/5 15:54
 */
public interface UserMapper {

    UserDO selectUserByUserName(String userName);
    UserDO selectUserById(Integer UserID);
    void register(UserDO user);
    void update(UserDO user);

}
