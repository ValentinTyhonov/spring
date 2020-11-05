package com.example.spring;

import com.example.spring.model.Developer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Developer developer = (Developer) context.getBean("newDev");

        System.out.println(developer.getName());

        developer.throwSomeMysticException();

    }

}
