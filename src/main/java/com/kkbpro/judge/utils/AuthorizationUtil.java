package com.kkbpro.judge.utils;

import java.util.UUID;

public class AuthorizationUtil {

    // 密钥有效期（1小时）
    private static final Long validTime = 60L * 60 * 1000;

    public static final String AccessKeyValidInfo = "AccessKey有效";

    /**
     * 生成AccessKey
     */
    public static String createAccessKey() {
        return System.currentTimeMillis() + "-" + UUID.randomUUID() + "-" + (System.currentTimeMillis() + validTime);
    }

    /**
     * 生成SecretKey
     */
    public static String createSecretKey(String AccessKey) {
        return AesUtil.aesEncrypt(AccessKey);
    }

    /**
     * 校验签名密钥
     */
    public static String checkKey(String AccessKey, String SecretKey) {
        if(AccessKey == null || AccessKey.isEmpty()) return "AccessKey为空！";
        if(SecretKey == null || SecretKey.isEmpty()) return "SecretKey为空！";
        System.out.println(AesUtil.aesDecrypt(SecretKey));
        if(!AccessKey.equals(AesUtil.aesDecrypt(SecretKey))) return "SecretKey不正确！";
        String[] splits = AccessKey.split("-");
        if(splits.length < 3) return "AccessKey格式错误！";
        try {
            long start = Long.parseLong(splits[0]);
            long end = Long.parseLong(splits[splits.length - 1]);
            if(!(System.currentTimeMillis() > start && System.currentTimeMillis() < end))
                return "AccessKey已过期";
        } catch (Exception e) {
            e.printStackTrace();
            return "AccessKey格式错误！";
        }
        return AccessKeyValidInfo;
    }

}
