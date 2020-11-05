package com.example.spring.config;

import com.example.spring.model.Developer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig
{
    @Bean
    public Developer newDev()
    {
        return new Developer("Tom", "Java Dev", 3);
    }
}
