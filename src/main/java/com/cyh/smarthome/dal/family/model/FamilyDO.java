package com.cyh.smarthome.dal.family.model;

import lombok.Data;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 16:00
 */
@Data
public class FamilyDO {
    private Integer familyID;
    private String familyTelephone;
    private String familyAddress;
    private Integer familyDeleteFlag;

}
