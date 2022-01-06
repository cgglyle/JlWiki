package pers.cgglyle.common.annotaion;

import java.lang.annotation.*;

/**
 * Redis缓存注解
 * <p> 可以在方法上添加此注解, 添加注解后会利用切面来进行缓存
 * <p> 缓存名：返回类型+方法名+参数哈希
 *
 * @author cgglyle
 * @date 2021-12-23 11:38
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
    /**
     * 超时时间
     * <p>默认3600秒
     */
    long timeout() default 3600L;
}
