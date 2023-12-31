package com.blog.dbblog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志注解
 *
 * @author wuxi
 * @create 2023-08-21
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogSys {

    /**
     * 日志描述
     */
    String desc() default "";

    /**
     * 日志操作类型
     */
    OperationType operationType() default OperationType.SYSTEM;

}
