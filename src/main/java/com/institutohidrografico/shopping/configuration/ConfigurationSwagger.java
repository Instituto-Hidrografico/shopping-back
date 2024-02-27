package com.institutohidrografico.shopping.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class ConfigurationSwagger {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("Group Name")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(apiInfo())
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "My REST API",
//                "Some custom description of API.",
//                "API TOS",
//                "Terms of service",
//                new Contact("John Doe", "www.example.com", "myeaddress@company.com"),
//                "License of API", "API license URL", Collections.emptyList());
//    }
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger with Spring Boot + Security")
                .version("1.0.0")
                .description("Your Description")
                .termsOfServiceUrl("Terms of service")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Contact Name", "Contact_URL","contact@email.com"))
                .build();
    }
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}