package com.kkbpro.judge.pojo;

import com.kkbpro.judge.pojo.vo.ExecuteInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 统一返回结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    // 状态
    private String status;

    // 响应码
    private Integer code;

    // 状态信息
    private String info;

    // 返回数据
    private Object data;

    public static Result error(Integer code, String info)
    {
        Result result = new Result();
        result.setStatus("error");
        result.setCode(code);
        result.setInfo(info);
        result.setData(null);
        return result;
    }

    public static Result warning(Integer code, String info)
    {
        Result result = new Result();
        result.setStatus("warning");
        result.setCode(code);
        result.setInfo(info);
        result.setData(null);
        return result;
    }

    public static Result success(Integer code, String info, ExecuteInfo executeInfo) {
        Result result = new Result();
        result.setStatus("success");
        result.setCode(code);
        result.setInfo(info);
        result.setData(executeInfo);
        return result;
    }

    public static Result success(Integer code, String info, Map<String,Object> map) {
        Result result = new Result();
        result.setStatus("success");
        result.setCode(code);
        result.setInfo(info);
        result.setData(map);
        return result;
    }

}