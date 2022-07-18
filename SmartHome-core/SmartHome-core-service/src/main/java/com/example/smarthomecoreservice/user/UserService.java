package com.example.smarthomecoreservice.user;


import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecoremodel.user.Param.UserRegisterParam;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    UserDO selectUserByUserNameAndPwd(String userName, String userPassword);
    UserDO selectUserByUserID(String userID);
    Integer userRegister(UserRegisterParam user);
    boolean userNameAvailable(String userName);
    UserDO selectUserByUserNameAndTel(String userName, String userTelephone);
    UserDO getUserInfo(HttpServletRequest request);
    void setNewToken(UserDO user, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, NoSuchAlgorithmException;
}
