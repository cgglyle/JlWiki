package pers.cgglyle;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@EnableConfigurationProperties({JWikiSecurityConfig.class})
@SpringBootApplication
public class StartupApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);
        log.info("""
                
                      __...--~~~~~-._   _.-~~~~~--...__          +---------------------------------+\s
                    //               `V'               \\\\\s       | JWiki 启动成功！                  |\s
                   //                 |                 \\\\\s      +---------------------------------+\s
                  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\\s     | 欢迎使用JWiki                    |\s
                 //__.....----~~~~._\\ | /_.~~~~----.....__\\\\     | JWiki后台服务启动正常              |\s
                ====================\\\\|//====================    +---------------------------------+ \s
                """);
    }
}
