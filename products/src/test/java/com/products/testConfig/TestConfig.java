package com.products.testConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.products") // Adjust the package name
public class TestConfig {
    // Additional test-specific configuration can go here
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

