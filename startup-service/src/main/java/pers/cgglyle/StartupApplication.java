package pers.cgglyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pers.cgglyle.common.config.JWikiSecurityConfig;

/**
 * 启动类
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@EnableConfigurationProperties({JWikiSecurityConfig.class})
@SpringBootApplication
public class StartupApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);
    }
}
