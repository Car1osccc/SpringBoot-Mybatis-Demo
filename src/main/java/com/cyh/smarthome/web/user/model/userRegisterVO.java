package com.cyh.smarthome.web.user.model;

import lombok.Data;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 15:09
 */
@Data
public class userRegisterVO {
    private String userName;
    private String userPassword;
    private String userTelephone;
    private String userAddress;
    private String userGender;
}
