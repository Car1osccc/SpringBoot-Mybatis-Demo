package com.example.smarthomeweb.user.mapping;

import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecoremodel.user.Param.UserRegisterParam;
import com.example.smarthomeweb.user.request.UserRegisterRequest;
import com.example.ssodemo.interceptor.LoginContext;
import com.example.ssodemo.model.UserDetailModel;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Yihan Chen
 * @date 2022/7/12 11:35
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
    public static UserDetailModel convert1(UserDO userDO) {
        UserDetailModel user = new UserDetailModel();
        user.setUserID(userDO.getUserID());
        user.setFamilyID(userDO.getFamilyID());
        user.setUserName(userDO.getUserName());
        user.setUserPassword(userDO.getUserPassword());
        user.setUserTelephone(userDO.getUserTelephone());
        user.setUserGender(userDO.getUserGender());
        user.setUserAddress(userDO.getUserAddress());
        user.setUserRegisterTime(Timestamp.valueOf(LocalDateTime.now()));
        return user;
    }

    public static LoginContext convert(UserDO userDO) {
        LoginContext context = new LoginContext();
        context.setUserID(userDO.getUserID());
        context.setFamilyID(userDO.getFamilyID());
        context.setUserName(userDO.getUserName());
        return context;
    }

}
