package com.example.spring.service;

import com.example.spring.model.Country;
import com.example.spring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService
{
    private CountryRepository countryRepository;

    CountryServiceImpl(@Autowired CountryRepository countryRepository)
    {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country)
    {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll()
    {
//        return countryRepository.findAll();
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Country get(long id)
    {
        return countryRepository.getOne(id);
    }

    @Override
    public void delete(Long id) throws IOException
    {
        if (countryRepository.existsById(id))
        {
            countryRepository.deleteById(id);
        }
        throw new IOException("Failed");
    }

    @Override
    public List<Country> getPage()
    {
//        Page<Country> page = countryRepository.findAll(PageRequest.of(2, 5, Sort.by(Sort.Direction.DESC, "name")));
//        return page.getContent();

        return countryRepository.findAllList(PageRequest.of(2, 5));
    }
}
