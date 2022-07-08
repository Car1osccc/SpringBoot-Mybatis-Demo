package com.cyh.smarthome.core.service.user.userServiceImpl;

import com.cyh.smarthome.core.service.family.FamilyService;
import com.cyh.smarthome.dal.family.model.Family;
import com.cyh.smarthome.dal.user.mapper.UserMapper;
import com.cyh.smarthome.dal.user.model.User;
import com.cyh.smarthome.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/6 10:50
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private FamilyService familyService;

    @Override
    public User selectUserByUserName(String userName, String userPassword){
        return userMapper.selectUserByUserName(userName,userPassword);
    }

    @Override
    public User selectUserByUserID(String userID) {
        return userMapper.selectUserById(userID);
    }

    @Override
    public void userRegister(User user) {

        if (familyService.getFamilyIdByAddress(user.getUserAddress())!=null){
            user.setFamilyID(familyService.getFamilyIdByAddress(user.getUserAddress()));
        }else {
            user.setFamilyID(familyService.createNewFamily(user.getUserTelephone(),user.getUserAddress()));
        }
        userMapper.register(user);
    }
}