package com.example.smarthomeweb.user.request;

import lombok.Data;

/**
 * @author Yihan Chen
 * @date 2022/7/8 15:09
 */
@Data
public class UserRegisterRequest {
    private String userName;
    private String userPassword;
    private String userTelephone;
    private String userAddress;
    private String userGender;
}
