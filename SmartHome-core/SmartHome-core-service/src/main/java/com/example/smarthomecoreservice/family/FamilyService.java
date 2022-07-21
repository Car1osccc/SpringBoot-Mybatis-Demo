package com.example.smarthomecoreservice.family;

import com.example.smarthomecommondal.family.model.FamilyDO;

/**
 * @author Yihan Chen
 * @date 2022/7/8 15:48
 */
public interface FamilyService {

    /**
     * 根据家庭住址查询FamilyID
     * @param familyAddress 家庭住址
     * @return FamilyID
     */
    Integer getFamilyIdByAddress(String familyAddress);

    /**
     * 根据家庭电话以及家庭住址注册新家庭，并返回FamilyDO
     * @param familyTelephone 家庭电话
     * @param familyAddress 家庭住址
     * @return FamilyDO
     */
    FamilyDO createNewFamily(String familyTelephone, String familyAddress);

}
