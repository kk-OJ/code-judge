package com.kkbapps.judge.pojo.vo;


import com.kkbapps.judge.pojo.dto.JudgeConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteInfo {

    // 执行结果类型
    private String executeType;

    // 执行结果
    private String executeResult;

    // 代码输出
    private String output;

    // 执行时间
    private Long time;

    // 消耗内存
    private Long memory;
}
