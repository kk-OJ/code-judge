package com.kkbpro.judge.pojo.dto;

import com.kkbpro.judge.annotation.VerifyParam;
import com.kkbpro.judge.constant.enums.JudgeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudgeConstraint {

    // 要执行的代码
    @VerifyParam(required = true, maxLen = 64 * 1024)
    private String code;

    // 代码语言
    @VerifyParam(required = true)
    private String lang;

    // 执行类型 JudgeTypeEnum
    private Integer type = JudgeTypeEnum.EXECUTE_CODE_ONLY.getState();

    // 限制时间
    @VerifyParam(minVal = 200L, maxVal = 5000L)
    private Long timeLimit = 1000L;

    // 限制内存
    @VerifyParam(minVal = 32L * 1024 * 1024, maxVal = 512L * 1024 * 1024)
    private Long memoryLimit = 256L * 1024 * 1024;

    // 需要判题，传入题目id
    private String id;

    // 仅执行代码的输入数据
    private String[] inputs = {""};
}
