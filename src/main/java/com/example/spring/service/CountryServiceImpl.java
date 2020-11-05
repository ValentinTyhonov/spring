package com.example.spring.service;

import com.example.spring.model.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryServiceImpl implements CountryService
{
    private Session session;

    CountryServiceImpl(@Autowired Session session)
    {
        this.session = session;
    }

    @Override
    public List<Country> getAll()
    {
        return session.createQuery("FROM Country c").getResultList();
    }

    @Override
    public void save(Country country)
    {
        Transaction transaction = session.beginTransaction();
        session.save(country);
        transaction.commit();
    }
}
