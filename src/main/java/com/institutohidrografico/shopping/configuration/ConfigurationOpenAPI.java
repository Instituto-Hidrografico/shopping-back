package com.institutohidrografico.shopping.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration @RequiredArgsConstructor
public class ConfigurationOpenAPI {
    @Value("${gadelha.openapi.dev-url}")
    private String devUrl;

    @Value("${gadelha.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Title")
                        .version("0.0.1")
                        .contact(new Contact()
                                .email("gadelha.ti@gmail.com")
                                .name("Marcelo Gadelha")
                                .url("https://www.gadelha.eti.br"))
                        .description("This API exposes endpoints to manage demo.").termsOfService("https://www.pasanabeysekara.com")
                        .license(new License()
                                .name("MIT License")
                                .url("https://choosealicense.com/licenses/mit/")))
                .servers(List.of(
                        new Server().url(devUrl).description("Server URL in Development environment"),
                        new Server().url(prodUrl).description("Server URL in Production environment")));
    }
}