package com.example.smarthomeweb.user.mapping;

import com.example.smarthomecoremodel.user.Param.UserRegisterParam;
import com.example.smarthomeweb.user.request.UserRegisterRequest;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/12 11:35
 */
public class UserMapping {
    public static UserRegisterParam convert(UserRegisterRequest userRegisterRequest) {
        UserRegisterParam userRegisterParam = new UserRegisterParam();
        userRegisterParam.setUserName(userRegisterRequest.getUserName());
        userRegisterParam.setUserPassword(userRegisterRequest.getUserPassword());
        userRegisterParam.setUserTelephone(userRegisterRequest.getUserTelephone());
        userRegisterParam.setUserGender(userRegisterRequest.getUserGender());
        userRegisterParam.setUserAddress(userRegisterRequest.getUserAddress());
        userRegisterParam.setUserRegisterTime(Timestamp.valueOf(LocalDateTime.now()));
        return userRegisterParam;
    }

}
