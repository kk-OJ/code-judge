package com.kkbpro.judge.exception;

import com.kkbapps.iprestrictionsbootstarter.Exception.IpRequestErrorException;
import com.kkbpro.judge.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author <a href="https://github.com/zyyzyykk">zyyzyykk</a>
 * @from <a href="https://kkbpro.com">kk导航</a>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)  // 捕获自定义异常
    public Result businessEx(BusinessException ex)
    {
        ex.printStackTrace();
        return ex.getResult();
    }

    @ExceptionHandler(IpRequestErrorException.class)  // 捕获ip请求异常
    public Result businessEx(IpRequestErrorException ex)
    {
        ex.printStackTrace();
        return Result.error(403,ex.getIpRequestErrorEnum().getDesc());
    }

    @ExceptionHandler(Exception.class)  // 捕获运行时抛出的异常
    public Result ex(Exception ex)
    {
        ex.printStackTrace();
        return Result.error(500,"操作失败，请联系管理员");
    }
}
