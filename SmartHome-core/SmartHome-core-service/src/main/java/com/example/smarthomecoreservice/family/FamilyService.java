package com.example.smarthomecoreservice.family;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 15:48
 */
public interface FamilyService {

    Integer getFamilyIdByAddress(String familyAddress);

    Integer createNewFamily(String familyTelephone,String familyAddress);

}
