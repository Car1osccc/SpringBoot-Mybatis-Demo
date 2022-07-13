package com.example.smarthomecoreservice.user.userServiceImpl;

import com.example.smarthomecommondal.user.mapper.UserMapper;
import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecommonutil.FormatVerifyUtil;
import com.example.smarthomecommonutil.enums.RegisterStatusEnum;
import com.example.smarthomecoreservice.family.FamilyService;
import com.example.smarthomecoreservice.user.UserService;
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

    @Resource
    private FamilyService familyService;

    @Override
    public UserDO selectUserByUserNameAndPwd(String userName, String userPassword) {
        UserDO user = userMapper.selectUserByUserName(userName);
        if (user == null) {
            return null;
        } else if (user.getUserPassword().equals(userPassword)) {
            return user;
        } else return null;
    }

    @Override
    public UserDO selectUserByUserID(String userID) {
        return userMapper.selectUserById(userID);
    }

    @Override
    public Integer userRegister(UserDO user) {

        Integer familyID = familyService.getFamilyIdByAddress(user.getUserAddress());
        if (familyID != null) {
            user.setFamilyID(familyID);
        } else {
            user.setFamilyID(familyService.createNewFamily(user.getUserTelephone(), user.getUserAddress()));
        }
        if (!userNameAvailable(user.getUserName())) {
            return RegisterStatusEnum.USERNAME_INVALID.ordinal();
        } else if (!FormatVerifyUtil.isMobilePhone(user.getUserTelephone())){
            return RegisterStatusEnum.TELEPHONE_INVALID.ordinal();
        }else{
            userMapper.register(user);
            return RegisterStatusEnum.REGISTER_SUCCESS.ordinal();
        }

    }

    @Override
    public boolean userNameAvailable(String userName) {
        return userMapper.selectUserByUserName(userName) == null;
    }

    @Override
    public UserDO selectUserByUserNameAndTel(String userName, String userTelephone) {
        UserDO user = userMapper.selectUserByUserName(userName);
        if (user == null) {
            return null;
        } else if (user.getUserTelephone().equals(userTelephone)) {
            return user;
        } else return null;
    }
}