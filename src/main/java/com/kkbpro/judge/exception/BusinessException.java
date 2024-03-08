package com.kkbpro.judge.exception;

import com.kkbpro.judge.pojo.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常，解决参数校验问题
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
    private Result result;
    public BusinessException(Result result){
        super(result.getInfo());
        this.result = result;
    }
}
