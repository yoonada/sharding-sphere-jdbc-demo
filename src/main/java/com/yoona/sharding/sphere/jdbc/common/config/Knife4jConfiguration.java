package com.yoona.sharding.sphere.jdbc.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author: yoonada
 * @email: m15602498163@163.com
 * @create: 2021-08-31 18:59
 * @description:
 */
@Configuration
@EnableSwagger2WebMvc
@EnableKnife4j
public class Knife4jConfiguration {

    @Value("${spring.application.name}")
    private String title;

    @Bean
    public Docket baseRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        String description = String.join("", title, "的接口文档");
        title = String.join("", title, " RESTful APIs");
        return new ApiInfoBuilder().title(title).description(description).termsOfServiceUrl("")
                .contact(new Contact("", "", "m15602498163@163.com")).version("1.0").build();
    }

}