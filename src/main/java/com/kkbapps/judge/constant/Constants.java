package com.kkbapps.judge.constant;

import java.util.HashMap;

/**
 * 常量类
 */
public class Constants {

    // 编程语言
    public static final String[] LANGUAGE = {"JAVA"};

    // 编程语言对应的docker镜像
    public static final String[] IMAGES = {"openjdk:8-alpine"};

    // 镜像拉取标记
    public static final Boolean[] INIT = {false};

    // 编程语言-数组索引
    public static HashMap<String,Integer> languageIndexMap = null;

    static {
        languageIndexMap = new HashMap<>();
        for(int i=0;i<LANGUAGE.length;i++) languageIndexMap.put(LANGUAGE[i],i);
    }
}