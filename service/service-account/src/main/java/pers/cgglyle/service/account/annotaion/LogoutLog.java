package pers.cgglyle.service.account.annotaion;

import java.lang.annotation.*;

/**
 * 登出日志注解
 *
 * @author cgglyle
 * @date 2021-12-21 11:36
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogoutLog {
}
