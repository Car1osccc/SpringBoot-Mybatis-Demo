package com.example.smarthomeweb.user.mapping;

import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecoremodel.user.Param.UserRegisterParam;
import com.example.smarthomeweb.user.request.UserRegisterRequest;
import com.example.ssodemo.model.UserDetailModel;

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

    public static UserDetailModel convert(UserDO userDO) {
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserName(userDO.getUserName());
        userDetailModel.setUserPassword(userDO.getUserPassword());
        userDetailModel.setUserTelephone(userDO.getUserTelephone());
        userDetailModel.setUserGender(userDO.getUserGender());
        userDetailModel.setUserAddress(userDO.getUserAddress());
        userDetailModel.setUserRegisterTime(userDO.getUserRegisterTime());
        userDetailModel.setUserID(userDO.getUserID());
        userDetailModel.setFamilyID(userDO.getFamilyID());
        return userDetailModel;
    }

}
