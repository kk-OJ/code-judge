package com.kkbapps.judge.exception;

import com.kkbapps.judge.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author <a href="https://github.com/zyyzyykk">zyyzyykk</a>
 * @from <a href="https://kkbpro.com">kk导航</a>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)  // 捕获运行时抛出的异常
    public Result ex(Exception ex)
    {
        ex.printStackTrace();
        return Result.error(500,"操作失败，请联系管理员");
    }
    @ExceptionHandler(BusinessException.class)  // 捕获自定义异常
    public Result businessEx(BusinessException ex)
    {
        ex.printStackTrace();
        return ex.getResult();
    }
}
