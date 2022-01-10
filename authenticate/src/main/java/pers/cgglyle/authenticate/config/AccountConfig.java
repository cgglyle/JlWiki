package pers.cgglyle.authenticate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.cgglyle.authenticate.service.LoginService;
import pers.cgglyle.authenticate.service.impl.LoginServiceImpl;
import pers.cgglyle.common.response.GlobalExceptionHandler;

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
