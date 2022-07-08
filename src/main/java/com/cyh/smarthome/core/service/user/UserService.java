package com.cyh.smarthome.core.service.user;

import com.cyh.smarthome.dal.user.model.UserDO;

public interface UserService {

    UserDO selectUserByUserName(String userName, String userPassword);
    UserDO selectUserByUserID(String userID);
    void userRegister(UserDO user);

}
