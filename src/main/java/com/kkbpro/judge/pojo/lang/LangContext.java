package com.kkbpro.judge.pojo.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LangContext {
    // 编程语言
    private String lang;

    // 保存文件名
    private String sourceFileName;

    // 编程语言对应的docker镜像
    private String image;

    // 编程语言对应执行的编译命令
    private String compileCmd;

    // 编程语言对应执行的启动命令
    private String[] runCmd;

}