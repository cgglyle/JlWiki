package pers.cgglyle.service.account.annotaion;

import java.lang.annotation.*;

/**
 * 登陆系统日志注解
 *
 * @author cgglyle
 * @date 2021-12-17 10:34
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLog {
}
