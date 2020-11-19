package com.example.spring.repository;

import com.example.spring.model.Country;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class CountryRepositoryTest
{
    @Autowired
    private CountryRepository repository;


    @BeforeEach
    public void init()
    {
        Country country = new Country(1L, "Ukraine", 224);
        repository.saveAndFlush(country);
    }

    @Test
    public void testGet()
    {
        Country country = repository.getOne(1L);
        assertEquals("Ukraine", country.getName());
    }

    @AfterEach
    public void cleanup()
    {
        repository.deleteById(1L);
    }
}
