package com.kkbapps.judge.constant;

import java.io.File;
import java.util.HashMap;

/**
 * 常量类
 */
public class Constants {

    // 编程语言
    public static final String[] LANGUAGE = {"JAVA"};

    // 编程语言对应的预处理类的全类名
    public static final String[] LANG_CODETEMPLATE_CLASSNAME = {"com.kkbapps.judge.utils.code.lang.JavaCodeTemplate"};

    // 编程语言对应的docker镜像
    public static final String[] IMAGES = {"openjdk:8-alpine"};

    // 镜像拉取标记
    public static final Boolean[] INIT = {false};

    // 编程语言-数组索引
    public static final HashMap<String,Integer> languageIndexMap = new HashMap<>();

    // 初始化映射关系
    static {
        for(int i=0;i<LANGUAGE.length;i++) languageIndexMap.put(LANGUAGE[i],i);
    }

    // 容器数据卷路径
    public static final String containerVolumePath = "/data";

    // 编程语言对应执行的编译命令
    public static final String[] langCompileCmd = {"javac -encoding utf-8 %s"};

    // 编程语言对应执行的启动命令
    public static final String[][] langRunCmd = {{"java", "-cp", containerVolumePath, "Main"}};

    // 评测代码根文件夹
    public static final String codeSourcePath = System.getProperty("user.dir") + File.separator + "source";


}