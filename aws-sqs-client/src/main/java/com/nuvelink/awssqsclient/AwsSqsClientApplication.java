package com.nuvelink.awssqsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableSwagger2
public class AwsSqsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsClientApplication.class, args);
    }
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.nuvelink.awssqsclient"))                      
          .build();                                           
    }

}
