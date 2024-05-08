package br.com.springboot3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Java 18 and Spring Boot 3")
                        .version("v1")
                        .description("some description about your API")
                        .termsOfService("w")
                        .license(new License()
                                .name("My Code")
                                .url("https://github.com/RenanMafort/Spring-Boot-framework-Swagger-JWT-JUnit-5-Mockito-Docker")));
    }
}
