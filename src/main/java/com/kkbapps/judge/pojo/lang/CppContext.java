package com.kkbapps.judge.pojo.lang;

import com.kkbapps.judge.constant.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;

@Data
@EqualsAndHashCode(callSuper = false)
public class CppContext extends LangContext {
    // 编程语言
    private final String lang = "c++";

    // 保存文件名
    private final String sourceFileName = "Main.cpp";

    // 编程语言对应的docker镜像
    private final String image = "gcc";

    // 镜像拉取标记
    private Boolean init = true;

    // 编程语言对应执行的编译命令
    private final String compileCmd = "g++ -o Main %s -finput-charset=UTF-8";

    // 编程语言对应执行的启动命令
    private final String[] runCmd = {Constants.containerVolumePath + File.separator + "Main"};
}