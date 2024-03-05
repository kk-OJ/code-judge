package com.kkbapps.judge.annotation;

import com.kkbapps.judge.constant.enums.ReEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyParam {

    /**
     * 最小长度
     */
    int minLen() default -1;

    /**
     * 最大长度
     */
    int maxLen() default Integer.MAX_VALUE;

    /**
     * 最小值
     */
    long minVal() default -1;

    /**
     * 最大值
     */
    long maxVal () default  Long.MAX_VALUE;

    /**
     * 是否必需
     */
    boolean required() default false;

    /**
     * 是否进行正则校验
     */
    ReEnum re() default ReEnum.NO;
}