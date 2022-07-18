package com.example.smarthomecommondal.family.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 16:00
 */
@Data
public class FamilyDO {

    /**
     * 家庭ID
     */
    private Integer familyID;

    /**
     * 家庭电话，默认为注册人手机号
     */
    private String familyTelephone;

    /**
     * 家庭地址，默认为注册人地址
     */
    private String familyAddress;

    /**
     * 家庭注册时间
     */
    private Timestamp familyRegisterTime;

    /**
     * 是否删除
     */
    private Integer familyDeleteFlag;

}
