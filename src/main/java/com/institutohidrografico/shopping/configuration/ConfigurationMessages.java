package com.institutohidrografico.shopping.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ConfigurationMessages {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/error_messages", "classpath:/messages/response_messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}