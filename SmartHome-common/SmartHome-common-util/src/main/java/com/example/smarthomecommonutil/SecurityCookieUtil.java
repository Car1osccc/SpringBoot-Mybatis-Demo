package com.example.smarthomecommonutil;

import com.alibaba.fastjson.JSON;
import com.example.smarthomecommondal.user.model.UserDO;
import com.example.smarthomecommonutil.constants.CookieConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @Author: Yihan Chen
 * @Date: 2022/7/18 13:37
 */
@Slf4j
public class SecurityCookieUtil {
    private final static int defaultLength = 32;


    public static String encryptUserInfo(Object object) {
        String cookie = JSON.toJSONString(object);
        byte[] cookieByte = cookie.getBytes(StandardCharsets.UTF_8);
        byte[] keyByte = CookieConstants.getKey().getBytes(StandardCharsets.UTF_8);
        String code = new String(RC4Base(cookieByte, keyByte));
        return URLEncoder.encode(code, StandardCharsets.UTF_8);
    }

    public static String generateToken(String encryptedInfo) {
        String time = String.format("%015d", new Date().getTime());
        String encryptBase = time + encryptedInfo;
        String md5Str = DigestUtils.md5DigestAsHex(encryptBase.getBytes(StandardCharsets.UTF_8));
        return md5Str + encryptBase;
    }

    public static UserDO getUserInfo(String encryptedInfo) {

        String decodeCookie = URLDecoder.decode(encryptedInfo,StandardCharsets.UTF_8);
        byte[] cookieByte = decodeCookie.getBytes(StandardCharsets.UTF_8);
        byte[] keyByte = CookieConstants.getKey().getBytes(StandardCharsets.UTF_8);
        String userString = new String(RC4Base(cookieByte, keyByte));
        try{
            return JSON.parseObject(userString, UserDO.class);
        }catch (Exception e){
            log.error("未找到token对应账号");
            return null;
        }
    }

    public static UserDO checkToken(String token){
        if (token.length()<defaultLength){
            return null;
        }
        String md5Str = token.substring(0,defaultLength);
        String encryptBase = token.substring(defaultLength);
        if (!DigestUtils.md5DigestAsHex(encryptBase.getBytes(StandardCharsets.UTF_8)).equals(md5Str)){
            log.error("非法token:{}",token);
            return null;
        }
        String time = token.substring(defaultLength,defaultLength + 15);
        if ((new Date().getTime()-Long.parseLong(time))>60*60*1000){
            log.error("检测到超时token:{}",token);
            return null;
        }
        String encryptedInfo = token.substring(defaultLength + 15);
        return getUserInfo(encryptedInfo);
    }
    public void setToken(){

    }

    private static byte[] RC4Base(byte[] input, byte[] key) {
        int x = 0;
        int y = 0;
        int xorIndex;
        byte[] result = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            x = (x + 1) & 0xff;
            y = ((key[x] & 0xff) + y) & 0xff;
            byte temp = key[x];
            key[x] = key[y];
            xorIndex = ((key[x] & 0xff) + (key[y] & 0xff)) & 0xff;
            result[i] = (byte) (input[i] ^ key[xorIndex]);
        }
        return result;
    }

    public static void main(String[] args) {
        UserDO user = new UserDO();
        user.setUserID(101);
        user.setUserTelephone("13023870857");
        user.setUserAddress("dshiaohc xzo");
        user.setUserGender("Male");
        user.setUserName("Carlos");
        user.setUserPassword("123456");
        user.setFamilyID(101);
        System.out.println("待加密的用户:\t\t" + user);

        String code = encryptUserInfo(user);
        System.out.println("加密后的用户信息:\t" + code);
        String token = generateToken(code);
        System.out.println("得到的token:\t\t" + token);
        System.out.println("解密出的用户信息:\t" + checkToken(token));
    }
}
