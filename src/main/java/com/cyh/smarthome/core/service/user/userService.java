package com.cyh.smarthome.core.service.user;

import com.cyh.smarthome.dal.user.model.User;

public interface userService {

    User selectUserByUserName(String UserName, String UserPassword);
    User selectUserByUserID(String UserID);

}
