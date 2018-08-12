package com.rest.resttemplate.config;

import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper());
//        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }

    @Bean
    public Logger getLogger() {
        return Logger.getLogger(getClass().getName());
    }
}
