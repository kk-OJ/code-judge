package com.kkbpro.judge.constant;

import java.io.File;

/**
 * 常量类
 */
public class Constants {

    // 容器数据卷路径
    public static final String containerVolumePath = "/data";

    // 评测代码根文件夹
    public static final String codeSourcePath = System.getProperty("user.dir") + File.separator + "source";

    // 编译时间限制 (ms)
    public static final Long compileTimeLimit = 5000L;

    // 超时后继续执行时间限制

    public static final Long tleTimeLimit = 200L;

    // 最多执行次数
    public static final int maxInputsLength = 10;


}