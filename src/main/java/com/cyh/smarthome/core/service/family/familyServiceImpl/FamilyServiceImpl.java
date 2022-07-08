package com.cyh.smarthome.core.service.family.familyServiceImpl;

import com.cyh.smarthome.core.service.family.FamilyService;
import com.cyh.smarthome.dal.family.mapper.FamilyMapper;
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
