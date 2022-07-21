package com.example.smarthomecoreservice.family.familyServiceImpl;

import com.example.smarthomecommondal.family.mapper.FamilyMapper;
import com.example.smarthomecommondal.family.model.FamilyDO;
import com.example.smarthomecoreservice.family.FamilyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Yihan Chen
 * @date 2022/7/8 15:48
 */
@Slf4j
@Service
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private FamilyMapper familyMapper;

    @Override
    public Integer getFamilyIdByAddress(String userAddress) {
        return familyMapper.getFamilyIdByAddress(userAddress);
    }

    @Override
    public FamilyDO createNewFamily(String familyTelephone, String familyAddress) {
        FamilyDO family = new FamilyDO();
        family.setFamilyTelephone(familyTelephone);
        family.setFamilyAddress(familyAddress);
        family.setFamilyRegisterTime(Timestamp.valueOf(LocalDateTime.now()));
        familyMapper.createNewFamily(family);
        family = familyMapper.getFamilyById(getFamilyIdByAddress(familyAddress));
        log.info(family.toString()+"创建成功");
        return family;
    }
}
