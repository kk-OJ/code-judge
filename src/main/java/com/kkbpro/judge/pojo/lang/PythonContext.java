package com.kkbpro.judge.pojo.lang;

import com.kkbpro.judge.constant.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;


@Data
@EqualsAndHashCode(callSuper = false)
public class PythonContext extends LangContext {
    // 编程语言
    private final String lang = "python";

    // 保存文件名
    private final String sourceFileName = "main.py";

    // 编程语言对应的docker镜像
    private final String image = "python";

    // 编程语言对应执行的编译命令
    private final String compileCmd = null;

    // 编程语言对应执行的启动命令
    private final String[] runCmd = {"python", Constants.containerVolumePath + File.separator + "main.py"};
}