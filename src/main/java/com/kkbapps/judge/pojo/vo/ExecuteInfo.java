package com.kkbapps.judge.pojo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteInfo {

    // 执行的代码
    private String code;

    // 代码语言
    private String lang;

    // 执行结果
    private String output;

    // 执行时间
    private Long time;

    // 消耗内存
    private Long memory;

    // 是否超时
    private Boolean isTimeout;
}
