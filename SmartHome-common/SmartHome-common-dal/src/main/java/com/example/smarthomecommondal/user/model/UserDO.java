package com.example.smarthomecommondal.user.model;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


@Data
public class UserDO {

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
	 * 用户注册时间
	 */
	private Timestamp userRegisterTime;

	/**
	 * 是否删除
	 */
    private Integer userDeleteFlag;


}
