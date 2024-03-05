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
    private final String sourceFileName = "main.cpp";

    // 编程语言对应的docker镜像
    private final String image = "gcc";

    // 编程语言对应执行的编译命令
    private final String compileCmd = "g++ -o main %s -finput-charset=UTF-8";

    // 编程语言对应执行的启动命令
    private final String[] runCmd = {"./main"};
}