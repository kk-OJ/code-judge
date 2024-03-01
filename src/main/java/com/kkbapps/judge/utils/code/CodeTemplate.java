package com.kkbapps.judge.utils.code;

import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.pojo.dto.JudgeConstraint;

public interface CodeTemplate {

    /**
     * 执行代码
     */
    public Result executeCode(JudgeConstraint judgeConstraint, Integer index);
}