package com.kkbapps.judge.controller;

import com.kkbapps.judge.annotation.GlobalInterceptor;
import com.kkbapps.judge.annotation.VerifyParam;
import com.kkbapps.judge.constant.enums.LangContextEnum;
import com.kkbapps.judge.exception.BusinessException;
import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import com.kkbapps.judge.pojo.lang.LangContext;
import com.kkbapps.judge.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
public class JudgeController {

    @Autowired
    private JudgeService judgeService;

    @PostMapping("/execode")
    @GlobalInterceptor
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
