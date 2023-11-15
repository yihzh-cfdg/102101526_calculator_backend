package com.yhz.se.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Calculator API")
                        .description("基于Spring+Mybatis实现的计算器后端")
                        .version("v1.0.0-RELEASE")
                        .license(new License()
                                .name("许可协议")
                                .url("https://springdoc.org")));
    }
}