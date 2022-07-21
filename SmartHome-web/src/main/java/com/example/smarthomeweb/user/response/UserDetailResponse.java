package com.example.smarthomeweb.user.response;

import lombok.Data;

/**
 * @author Yihan Chen
 * @date 2022/7/21 17:55
 */
@Data
public class UserDetailResponse {

    /**
     * 用户ID
     */
    private Integer userID;

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
	 * 所在家庭ID
	 */
    private Integer familyID;

	/**
	 * 是否删除
	 */
    private Integer userDeleteFlag;

}
