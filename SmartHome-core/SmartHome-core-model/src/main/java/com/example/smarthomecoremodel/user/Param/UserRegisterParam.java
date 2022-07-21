package com.example.smarthomecoremodel.user.Param;

import lombok.Data;
import java.sql.Timestamp;

/**
 * @author Yihan Chen
 * @date 2022/7/15 09:53
 */
@Data
public class UserRegisterParam {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 手机号码
     */
    private String userTelephone;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     * 用户注册时间
     */
    private Timestamp userRegisterTime;
}
