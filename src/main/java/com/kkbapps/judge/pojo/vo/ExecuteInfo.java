package com.kkbapps.judge.pojo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteInfo {

    // 执行结果类型
    private String executeType;

    // 执行信息
    private String executeDetail;

    // 代码读入
    private List<String> stdin;

    // 代码输出
    private List<String> stdout;

    // 代码错误
    private List<String> stderr;

    // 执行时间
    private Long time;

    // 消耗内存
    private Long memory;
}
