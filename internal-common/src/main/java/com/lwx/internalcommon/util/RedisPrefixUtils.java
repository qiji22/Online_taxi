package com.lwx.internalcommon.util;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-17  16:09
 */
public class RedisPrefixUtils {
    //乘客验证码的前缀
    public static String verificationCodePrefix = "verification-code-";

    //token储存的前缀
    public static String tokenPrefix = "token-";

    /*
     * @description:根据手机号，生成key
     **/
    public static String generatorKeyByPhone(String phone,String identity){
        return verificationCodePrefix +identity + "-" + phone;
    }

    /*
     * @description:根据手机号和身份标识，生成token
     **/
    public static String generatorTokenKey(String phone, String identity,String tokenType){
        return tokenPrefix + phone + "-" + identity + "-" + tokenType;
    }
}
