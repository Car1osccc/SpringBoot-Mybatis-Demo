package com.example.smarthomecoreservice.user;


import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecoremodel.user.Param.UserRegisterParam;
/**
 * @author Yihan Chen
 * @date 2022/7/21 17:44
 */
public interface UserService {


    /**
     * 根据用户名以及密码查询UserDO
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return UserDO
     */
    UserDO checkByUserNameAndPwd(String userName, String userPassword);

    /**
     * 根据用户ID查询UserDO
     * @param userID 用户ID
     * @return UserDO
     */
    UserDO selectUserByUserID(Integer userID);

    /**
     * 收到注册信息进行注册，并返回注册是否成功，或是失败对应参数
     * @param user 用户注册Param
     * @return 注册参数
     */
    Integer userRegister(UserRegisterParam user);

    /**
     * 用户名是否可用
     * @param userName 用户名
     * @return boolean
     */
    boolean userNameAvailable(String userName);

    /**
     * 根据用户名以及手机号查询UserDO(找回密码功能)
     * @param userName 用户名
     * @param userTelephone 手机号
     * @return UserDO
     */
    UserDO selectUserByUserNameAndTel(String userName, String userTelephone);

    /**
     * 修改个人信息
     * @param userDO 更改的用户信息
     * @return 更改成功与否
     */
    boolean update(UserDO userDO);
}
