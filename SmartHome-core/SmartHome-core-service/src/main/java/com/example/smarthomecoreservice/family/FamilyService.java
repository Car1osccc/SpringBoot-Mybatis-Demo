package com.example.smarthomecoreservice.family;

import com.example.smarthomecommondal.family.model.FamilyDO;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 15:48
 */
public interface FamilyService {

    Integer getFamilyIdByAddress(String familyAddress);

    FamilyDO createNewFamily(String familyTelephone, String familyAddress);

}
