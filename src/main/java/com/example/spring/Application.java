package com.example.spring;

import com.example.spring.model.Country;
import com.example.spring.service.CountryService;
import com.example.spring.service.CountryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        CountryService countryService = context.getBean(CountryServiceImpl.class);

        countryService.getAll().stream()
            .map(Country::getName)
            .forEach(System.out::println);
    }

}
