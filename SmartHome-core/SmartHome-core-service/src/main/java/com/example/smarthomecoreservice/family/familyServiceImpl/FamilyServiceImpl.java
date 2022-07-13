package com.example.smarthomecoreservice.family.familyServiceImpl;

import com.example.smarthomecommondal.family.mapper.FamilyMapper;
import com.example.smarthomecoreservice.family.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/8 15:48
 */

@Service
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private FamilyMapper familyMapper;

    @Override
    public Integer getFamilyIdByAddress(String userAddress) {
        return familyMapper.getFamilyIdByAddress(userAddress);
    }

    @Override
    public Integer createNewFamily(String familyTelephone, String familyAddress) {
        familyMapper.createNewFamily(familyTelephone, familyAddress);
        return getFamilyIdByAddress(familyAddress);
    }
}
