package com.cyh.smarthome.core.service.user;

import com.cyh.smarthome.dal.user.model.User;

public interface UserService {

    User selectUserByUserName(String userName, String userPassword);
    User selectUserByUserID(String userID);
    void userRegister(User user);

}
