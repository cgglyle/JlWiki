package pers.cgglyle.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cgglyle
 * @date 2022-01-11 11:54
 */
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI()
                .info(new Info().title("JWiki API")
                        .description("JWiki项目的API文档")
                        .version("v1.0.0")
                        .license(new License().name("GPL-3.0").url("https://www.gnu.org")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("认证授权系统")
                .pathsToMatch("/**")
                .packagesToScan("pers.cgglyle.authenticate.controller")
                .build();
    }

    @Bean
    public GroupedOpenApi logApi() {
        return GroupedOpenApi.builder()
                .group("日志系统")
                .pathsToMatch("/**")
                .packagesToScan("pers.cgglyle.common.controller")
                .build();
    }

    @Bean
    public GroupedOpenApi wikiApi() {
        return GroupedOpenApi.builder()
                .group("wiki系统")
                .pathsToMatch("/**")
                .packagesToScan("pers.cgglyle.wiki.controller")
                .build();
    }
}
