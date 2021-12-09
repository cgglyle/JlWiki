package pers.cgglyle.util.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Knife4j配置类
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@EnableKnife4j
@EnableOpenApi
@Configuration
public class Knife4jConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .apiInfo(new ApiInfoBuilder()
                        .title("JWiki接口文档")
                        .description("JWikiApi")
                        .contact(new Contact("cgglyle", "https://github.com/cgglyle/JWiki", "cgglyle@outlook.com"))
                        .version("0.1")
                        .build())
                .groupName("0.1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("pers.cgglyle"))
                .paths(PathSelectors.any())
                .build();
    }
}
