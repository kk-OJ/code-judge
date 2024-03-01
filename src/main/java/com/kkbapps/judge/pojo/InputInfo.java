package com.kkbapps.judge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 输入数据信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputInfo {

    // 需要判题，传入题目id
    private String id;

    // 仅执行代码获取执行结果
    private String[] inputs;
}