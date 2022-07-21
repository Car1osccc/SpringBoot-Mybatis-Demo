package com.example.smarthomecoreservice.user.userServiceImpl;

import com.example.smarthomecommondal.user.mapper.UserMapper;
import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecommonutil.FormatVerifyUtil;
import com.example.smarthomecommonutil.enums.RegisterStatusEnum;
import com.example.smarthomecoremodel.user.Param.UserRegisterParam;
import com.example.smarthomecoreservice.family.FamilyService;
import com.example.smarthomecoreservice.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yihan Chen
 * @date 2022/7/6 10:50
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private FamilyService familyService;


    @Override
    public UserDO checkByUserNameAndPwd(String userName, String userPassword) {
        UserDO user = userMapper.selectUserByUserName(userName);
        if (user == null) {
            return null;
        } else if (user.getUserPassword().equals(userPassword)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public UserDO selectUserByUserID(Integer userID) {
        return userMapper.selectUserById(userID);
    }

    @Override
    public Integer userRegister(UserRegisterParam userRegisterParam) {
        UserDO user = new UserDO();
        Integer familyID = familyService.getFamilyIdByAddress(userRegisterParam.getUserAddress());
        if (!userNameAvailable(userRegisterParam.getUserName())) {
            return RegisterStatusEnum.USERNAME_INVALID.ordinal();
        } else if (!FormatVerifyUtil.isMobilePhone(userRegisterParam.getUserTelephone())) {
            return RegisterStatusEnum.TELEPHONE_INVALID.ordinal();
        } else {
            if (familyID != null) {
                user.setFamilyID(familyID);
            } else {
                user.setFamilyID(familyService.createNewFamily(userRegisterParam.getUserTelephone(), userRegisterParam.getUserAddress()).getFamilyID());
            }
            user.setUserName(userRegisterParam.getUserName());
            user.setUserPassword(userRegisterParam.getUserPassword());
            user.setUserGender(userRegisterParam.getUserGender());
            user.setUserAddress(userRegisterParam.getUserAddress());
            user.setUserRegisterTime(userRegisterParam.getUserRegisterTime());
            user.setUserTelephone(userRegisterParam.getUserTelephone());
            userMapper.register(user);
            log.info(userMapper.selectUserByUserName(user.getUserName()) + "创建成功");
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
        } else {
            return null;
        }
    }

    @Override
    public boolean update(UserDO userDO) {
        if (!FormatVerifyUtil.isMobilePhone(userDO.getUserTelephone())) {
            return false;
        }
        userMapper.update(userDO);
        return true;
    }

}