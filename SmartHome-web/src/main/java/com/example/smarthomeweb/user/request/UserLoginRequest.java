package com.example.smarthomeweb.user.request;

import lombok.Data;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 11:21
 */
@Data
public class UserLoginRequest {
    private String userName;
    private String userPassword;
}
