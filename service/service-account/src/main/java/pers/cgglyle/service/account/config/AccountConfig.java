package pers.cgglyle.service.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.cgglyle.common.response.GlobalExceptionHandler;
import pers.cgglyle.service.account.service.LoginService;
import pers.cgglyle.service.account.service.impl.LoginServiceImpl;

/**
 * 全局异常处理Account模块配置类
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@Configuration
public class AccountConfig {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl();
    }
}
