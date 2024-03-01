package com.kkbapps.judge.pojo.dto;

import com.kkbapps.judge.annotation.VerifyParam;
import com.kkbapps.judge.constant.enums.JudgeTypeEnum;
import com.kkbapps.judge.pojo.InputInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudgeConstraint {

    // 要执行的代码
    @VerifyParam(required = true, max = 8192)
    private String code;

    // 代码语言
    @VerifyParam(required = true)
    private String lang;

    // 执行类型 JudgeTypeEnum
    private Integer type = JudgeTypeEnum.EXECUTE_CODE_ONLY.getState();

    // 限制时间 TODO
    private Long timeLimit = 1000L;

    // 限制内存 TODO
    private Long memoryLimit = 100L * 1024 * 1024;

    // 输入数据
    private InputInfo inputInfo = new InputInfo();
}
