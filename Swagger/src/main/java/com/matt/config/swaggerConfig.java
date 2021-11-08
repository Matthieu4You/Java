package com.matt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class swaggerConfig {
    @Profile("dev")
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // any():扫描全部
                // none():都不扫描
                // withClassAnnotation():扫描类上的注解
                // withClassAnnotation(GetMapping.class)即扫描有@GetMapping注解的包
                .apis(RequestHandlerSelectors.basePackage("com.matt.controller"))
                // 过滤
                // 只扫描某路径下的包
                .paths(PathSelectors.ant("/matt/**"))
                .build()
                // 关闭Swagger
                .enable(false);

    }

    //配置Swagger信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("Matt","http://www.baidu.com","whocaresMatt@gmail.com");
        return new ApiInfo(
                "Matt's Swagger API Documentation",
                "lalalalalalalalalala",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

}
