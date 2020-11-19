package com.example.spring.service;

import com.example.spring.model.Country;

import java.io.IOException;
import java.util.List;

public interface CountryService
{
    Country save(Country country);

    List<Country> getAll();

    Country get(long id);

    void delete(Long id) throws IOException;

    List<Country> getPage();
}
