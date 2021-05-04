package com.in28minutes.rest.webservices.restfulwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

//Configuration
@Configuration
//Enable Swagger
//@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact(
            "Shubham Kumar",
            "http://www.github.com", "www.gmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Social Media Api",
            "Social Media Api Documentation",
            "1.0",
            "urn:tos",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList());

    //Bean - Docket
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }
    //Swagger 2
    // All paths
    // All APIs
}
