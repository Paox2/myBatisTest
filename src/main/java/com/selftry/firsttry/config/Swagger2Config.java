package com.selftry.firsttry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config {

    // http://localhost:8080/swagger-ui.html#/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.selftry.firsttry"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Use Swagger2")
                .description("simple style")
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }

    // localhost:8080/docs.html
//    @Bean
//    public Docket ProductApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .genericModelSubstitutes(DeferredResult.class)
//                .useDefaultResponseMessages(false)
//                .forCodeGeneration(false)
//                .pathMapping("/")
//                .select()
//                .build()
//                .apiInfo(productApiInfo());
//    }
//
//    private ApiInfo productApiInfo() {
//        ApiInfo apiInfo = new ApiInfo("XXX系统数据接口文档",
//                "文档描述。。。",
//                "1.0.0",
//                "API TERMS URL",
//                "联系人邮箱",
//                "license",
//                "license url");
//        return apiInfo;
//    }
}
