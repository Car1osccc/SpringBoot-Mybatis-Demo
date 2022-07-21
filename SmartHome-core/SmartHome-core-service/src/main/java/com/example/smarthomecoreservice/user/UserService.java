package com.example.smarthomecoreservice.user;


import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecoremodel.user.Param.UserRegisterParam;

public interface UserService {


    UserDO checkByUserNameAndPwd(String userName, String userPassword);
    UserDO selectUserByUserID(String userID);
    Integer userRegister(UserRegisterParam user);
    boolean userNameAvailable(String userName);
    UserDO selectUserByUserNameAndTel(String userName, String userTelephone);
}
