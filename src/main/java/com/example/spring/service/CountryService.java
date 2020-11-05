package com.example.spring.service;

import com.example.spring.model.Country;

import java.util.List;

public interface CountryService
{
    List<Country> getAll();

    void save(Country country);
}
