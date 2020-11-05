package com.example.spring.config;

import com.example.spring.model.Capital;
import com.example.spring.model.City;
import com.example.spring.model.Country;
import com.example.spring.model.Market;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig
{
    @Bean
    public Session session()
    {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Capital.class);
        configuration.addAnnotatedClass(City.class);
        configuration.addAnnotatedClass(Market.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory.openSession();
    }
}
