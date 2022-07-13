package com.example.smarthomecommonutil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * @Author: Yihan Chen
 * @Date: 2022/7/13 15:42
 */
public class FormatUtilTest {
    @Test
     void emailTest1(){
         String email = "1321312@qq.com";
         Assertions.assertTrue(FormatVerifyUtil.isEmail(email));
     }
    @Test
    void emailTest2(){
        String email = "1321312@qq.com.cn";
        Assertions.assertTrue(FormatVerifyUtil.isEmail(email));
    }
    @Test
    void emailTest3(){
        String email = "1321312-abc@qq.com";
        Assertions.assertTrue(FormatVerifyUtil.isEmail(email));
    }
    @Test
    void emailTest4(){
        String email = "jp2019213587@qmul.ac.uk";
        Assertions.assertTrue(FormatVerifyUtil.isEmail(email));
    }
    @Test
    void emailTest5(){
        String email = "1321312-@qq.com";
        Assertions.assertFalse(FormatVerifyUtil.isEmail(email));
    }
    @Test
    void phoneTest1(){
        String mobilePhone = "13023870857";
        Assertions.assertTrue(FormatVerifyUtil.isMobilePhone(mobilePhone));
    }
    @Test
    void phoneTest2(){
        String mobilePhone = "130238708573";
        Assertions.assertFalse(FormatVerifyUtil.isMobilePhone(mobilePhone));
    }
    @Test
    void phoneTest3(){
        String mobilePhone = "03023870857";
        Assertions.assertFalse(FormatVerifyUtil.isMobilePhone(mobilePhone));
    }
    @Test
    void phoneTest4(){
        String mobilePhone = "14023870857";
        Assertions.assertFalse(FormatVerifyUtil.isMobilePhone(mobilePhone));
    }

}
