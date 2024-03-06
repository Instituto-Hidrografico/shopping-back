package com.institutohidrografico.shopping.configuration;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationJts {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}