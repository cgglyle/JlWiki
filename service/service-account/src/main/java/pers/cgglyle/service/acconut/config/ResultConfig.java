package pers.cgglyle.service.acconut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.cgglyle.response.GlobalExceptionHandler;

/**
 * 全局异常处理Account模块配置类
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@Configuration
public class ResultConfig {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
