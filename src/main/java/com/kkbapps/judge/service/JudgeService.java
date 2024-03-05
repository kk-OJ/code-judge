package com.kkbapps.judge.service;


import com.kkbapps.judge.constant.Constants;
import com.kkbapps.judge.constant.enums.JudgeTypeEnum;
import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import com.kkbapps.judge.pojo.lang.LangContext;
import com.kkbapps.judge.utils.DockerUtil;
import com.kkbapps.judge.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class JudgeService {
    public Result exeCode(JudgeConstraint judgeConstraint, LangContext langContext) {
        Result result = null;
        File fileFolder = null;
        try {
            String folderPath = Constants.codeSourcePath + File.separator + UUID.randomUUID().toString();
            // 将代码保存
            fileFolder = FileUtil.saveFile(folderPath, langContext.getSourceFileName(), judgeConstraint.getCode());
            // 将测试用例保存(仅执行代码)
            if(JudgeTypeEnum.EXECUTE_CODE_ONLY.getState().equals(judgeConstraint.getType())) {
                for(int i=0;i<judgeConstraint.getInputs().length;i++) {
                    FileUtil.saveFile(folderPath, i + ".in", judgeConstraint.getInputs()[i]);
                }
            }
            // 使用Docker进行编译、执行代码并返回输出结果
            result = DockerUtil.executeCodeWithDocker(judgeConstraint, langContext, folderPath);
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
