package com.kkbpro.judge.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 字符串相关工具类
 */
public class StringUtil {

    /**
     * 生成随机字符与数字
     */
    public static final String getRandomStr(Integer count)
    {
        return RandomStringUtils.random(count,true,true);
    }

    /**
     * 生成随机数
     */
    public static final String getRandomNumber(Integer count)
    {
        return RandomStringUtils.random(count,false,true);
    }

    /**
     * md5加密密码
     */
    public static String encodeByMD5(String originString) {
        if(originString == null || originString.length() == 0) return null;
        return DigestUtils.md5Hex(originString);
    }

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String str) {

        if (null == str || "".equals(str) || "null".equals(str) || "\u0000".equals(str)) {
            return true;
        } else if ("".equals(str.trim())) {
            return true;
        }
        return false;
    }
}
