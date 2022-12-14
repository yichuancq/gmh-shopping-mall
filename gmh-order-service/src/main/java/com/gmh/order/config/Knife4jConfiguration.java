package com.gmh.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yichuan
 * Knife4jConfiguration
 */
@Configuration
public class Knife4jConfiguration {
    @Bean(value = "order api 1.0")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)//
                .apiInfo(new ApiInfoBuilder().title("order api 1.0")//
                        .description("订单api")//
                        .termsOfServiceUrl("http://www.test.com/")//
                        .contact(new Contact("test", "www.test" + ".com", "test@email.com")).version("1.0")//
                        .build())
                //分组名称
                .groupName("1.0版本").select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.gmh.order.controller"))//
                .paths(PathSelectors.any()).build();
        return docket;
    }
}