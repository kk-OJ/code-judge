package com.kkbapps.judge.pojo.lang;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GoContext extends LangContext {
    // 编程语言
    private final String lang = "golang";

    // 保存文件名
    private final String sourceFileName = "main.go";

    // 编程语言对应的docker镜像
    private final String image = "golang";

    // 编程语言对应执行的编译命令
    private final String compileCmd = "go build -o main %s";

    // 编程语言对应执行的启动命令
    private final String[] runCmd = {"./main"};
}

