package com.kkbapps.judge.utils.code.lang;

import com.kkbapps.judge.constant.Constants;
import com.kkbapps.judge.constant.enums.JudgeTypeEnum;
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
            fileFolder = FileUtil.saveFile(folderPath, sourceFileName, judgeConstraint.getCode());
            // 将测试用例保存
            // 仅执行代码
            if(JudgeTypeEnum.EXECUTE_CODE_ONLY.getState().equals(judgeConstraint.getType())) {
                for(int i=0;i<judgeConstraint.getInputs().length;i++) {
                    FileUtil.saveFile(folderPath, i + ".in", judgeConstraint.getInputs()[i]);
                }
            }
            // 普通判题
            else if(JudgeTypeEnum.NORMAL_JUDGE.getState().equals(judgeConstraint.getType())) {
                // FileUtil.copyFiles();
            }
            // 使用Docker进行编译、执行代码并返回输出结果
            result = DockerUtil.executeCodeWithDocker(judgeConstraint, index, folderPath, sourceFileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            // 删除相关文件
            FileUtil.delete(fileFolder);
        }
        return result;
    }

}
