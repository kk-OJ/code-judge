package com.kkbpro.judge.controller;

import com.kkbapps.iprestrictionsbootstarter.Annotation.EnableIPLimit;
import com.kkbpro.judge.annotation.GlobalInterceptor;
import com.kkbpro.judge.annotation.VerifyParam;
import com.kkbpro.judge.constant.enums.LangContextEnum;
import com.kkbpro.judge.exception.BusinessException;
import com.kkbpro.judge.pojo.Result;
import com.kkbpro.judge.pojo.dto.JudgeConstraint;
import com.kkbpro.judge.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeController {

    @Autowired
    private JudgeService judgeService;

    @PostMapping("/execode")
    @GlobalInterceptor
    @EnableIPLimit(count = Long.MAX_VALUE, interval = 3000L)
    public Result exeCode(@VerifyParam JudgeConstraint judgeConstraint) {
        // 校验语言
        LangContextEnum langContextEnum = LangContextEnum.getByLang(judgeConstraint.getLang().toLowerCase());
        if(langContextEnum == null) {
            throw new BusinessException(
                    Result.error(400,"暂不支持" + judgeConstraint.getLang() + "语言"));
        }
        // 校验题目是否存在
        // if()
        return judgeService.exeCode(judgeConstraint,langContextEnum.getLangContext());
    }

}
