package com.kkbapps.judge.controller;

import com.kkbapps.judge.annotation.GlobalInterceptor;
import com.kkbapps.judge.annotation.VerifyParam;
import com.kkbapps.judge.constant.Constants;
import com.kkbapps.judge.exception.BusinessException;
import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import com.kkbapps.judge.utils.code.CodeTemplateFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeController {

    @PostMapping("/execode")
    @GlobalInterceptor
    public Result exeCode(@VerifyParam JudgeConstraint judgeConstraint) {
        // 获取语言索引
        Integer index = Constants.languageIndexMap.get(judgeConstraint.getLang().toUpperCase());
        if(index == null) {
            throw new BusinessException(
                    Result.error(400,"暂不支持" + judgeConstraint.getLang() + "语言"));
        }
        return CodeTemplateFactory.get(index).executeCode(judgeConstraint, index);
    }

}
