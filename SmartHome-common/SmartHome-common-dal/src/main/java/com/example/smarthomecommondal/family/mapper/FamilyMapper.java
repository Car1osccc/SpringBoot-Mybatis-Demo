package com.example.smarthomecommondal.family.mapper;

import com.example.smarthomecommondal.family.model.FamilyDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 15:49
 */
@Mapper
public interface FamilyMapper {
    Integer getFamilyIdByAddress(String familyAddress);
    void createNewFamily(FamilyDO family);
    FamilyDO getFamilyById(Integer familyID);
}
