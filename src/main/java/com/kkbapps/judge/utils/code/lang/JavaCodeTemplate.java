package com.kkbapps.judge.utils.code.lang;

import com.kkbapps.judge.constant.Constants;
import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import com.kkbapps.judge.utils.DockerUtil;
import com.kkbapps.judge.utils.FileUtil;
import com.kkbapps.judge.utils.code.CodeTemplate;

import java.io.File;
import java.util.UUID;

public class JavaCodeTemplate implements CodeTemplate {

    private static final String sourceFileName = "Main.java";


    @Override
    public Result executeCode(JudgeConstraint judgeConstraint, Integer index) {
        Result result = null;
        File fileFolder = null;
        try {
            String folderPath = Constants.codeSourcePath + File.separator + UUID.randomUUID().toString();
            // 将代码保存
            fileFolder = FileUtil.saveFile(folderPath,sourceFileName,judgeConstraint.getCode());
            // 使用Docker进行编译、执行代码并返回输出结果
            result = DockerUtil.executeCodeWithDocker(judgeConstraint, index, folderPath, sourceFileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            // 删除相关文件
            FileUtil.delete(fileFolder);
        }
        return result;
    }

}
