package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableSwagger2   //开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    @Bean
    public Docket docket4(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
    }
    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //获取项目的环境：
        //设置要显示的swagger环境
        Profiles profiles=Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("狂神")
                .apiInfo(apiInfo())
                .enable(flag)
                //配置要扫描接口的方式
                //basePackage指定要扫描的包
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kuang.controller"))
                .build();
    }
    //配置swagger信息apiInfo

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("少伟", "https://awei.site/", "2659934495@qq.com");
        return  new ApiInfo(
              "Kuangshen的SwaggerApi文档",
              "学不死往死里学",
              "v1.0",
              "https://awei.site/",
                contact,
              "Apache 2.0",
              "http://www.apache.org/licenses/LICENSE-2.0",
              new ArrayList());
    }

}
