package com.example.smarthomecommonutil;

/**
 * @author Yihan Chen
 * @date 2022/7/13 15:26
 */
public class FormatVerifyUtil {
    public static boolean isEmail(String email) {
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return email.matches(regex);
    }
    public static boolean isMobilePhone(String mobilePhone){
        String regex = "^1(3[0-9]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\\d{8}$";
        return mobilePhone.matches(regex);
    }
}