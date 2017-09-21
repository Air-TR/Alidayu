package com.tr.alidayu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("Alidayu", "阿里大于")) // , getTags()
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tr.alidayu.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
//    private Tag[] getTags() {
//        Tag[] tags = {
//        		new Tag("Admin", "后台管理员"),
//        		new Tag("Admin", "后台管理员")
//        };
//        return tags;
//    }
    
    private ApiInfo apiInfo() {
        Contact contact = new Contact("taorun", "http://www.baidu.com", "tr1838@163.com");
        return new ApiInfoBuilder()
                .title("Alidayu")
                //.description("接口文档<br/>签名算法：String sign = MD5(userid + timestamp + secret);<br/>userid和secret将会预先给到调用方，请妥善保存。")
                .description("接口文档 api")
                .termsOfServiceUrl("http://www.google.com")
                .contact(contact)
                .version("1.0")
                .build();
    }

}
