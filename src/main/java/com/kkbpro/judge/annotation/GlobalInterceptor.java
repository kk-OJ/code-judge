package com.kkbpro.judge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalInterceptor {
    /**
     * 是否校验参数
     */
    boolean checkParams() default true;


    /**
     * 是否校验权限
     */
    boolean checkAuth() default true;
}