package com.example.smarthomecoreservice.user;


import com.example.smarthomecommondal.user.model.UserDO;

public interface UserService {

    UserDO selectUserByUserNameAndPwd(String userName, String userPassword);
    UserDO selectUserByUserID(String userID);
    Integer userRegister(UserDO user);
    boolean userNameAvailable(String userName);
    UserDO selectUserByUserNameAndTel(String userName, String userTelephone);

}
