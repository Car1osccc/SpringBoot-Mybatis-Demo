package com.example.smarthomeweb.user.mapping;

import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomeweb.user.request.UserRegisterRequest;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/12 11:35
 */
public class UserMapping {
    public static UserDO convert(UserRegisterRequest userRegisterRequest) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userRegisterRequest.getUserName());
        userDO.setUserPassword(userRegisterRequest.getUserPassword());
        userDO.setUserTelephone(userRegisterRequest.getUserTelephone());
        userDO.setUserGender(userRegisterRequest.getUserGender());
        userDO.setUserAddress(userRegisterRequest.getUserAddress());
        return userDO;
    }

}
