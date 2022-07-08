package com.cyh.smarthome.dal.family.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 15:49
 */
@Mapper
public interface FamilyMapper {
    Integer getFamilyIdByAddress(String familyAddress);
    void createNewFamily(String familyTelephone,String familyAddress);
}
