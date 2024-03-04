package com.kkbapps.judge.pojo.lang;

import com.kkbapps.judge.constant.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class JavaContext extends LangContext {
    // 编程语言
    private final String lang = "java";

    // 保存文件名
    private final String sourceFileName = "Main.java";

    // 编程语言对应的docker镜像
    private final String image = "openjdk:8-alpine";

    // 镜像拉取标记
    private Boolean init = true;

    // 编程语言对应执行的编译命令
    private final String compileCmd = "javac -encoding utf-8 %s";

    // 编程语言对应执行的启动命令
    private final String[] runCmd = {"java", "-cp", Constants.containerVolumePath, "Main"};
}
