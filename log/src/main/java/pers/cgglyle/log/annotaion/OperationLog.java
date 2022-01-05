package pers.cgglyle.log.annotaion;

import java.lang.annotation.*;

/**
 * 日志请求注解
 *
 * @author cgglyle
 * @date 2021-12-14 16:17
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {
    /**
     * 请求模块
     */
    String operationModule() default "";

    /**
     * 请求方式
     *
     * <p>GET,POST,PUT,DELETE</p>
     */
    String operationMethod() default "";
}
