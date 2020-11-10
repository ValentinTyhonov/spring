package com.example.spring.controller;

import com.example.spring.model.Country;
import com.example.spring.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController
{
    private CountryService countryService;

    CountryController(@Autowired CountryService countryService)
    {
        this.countryService = countryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Country> create(@RequestBody Country country)
    {
        Country created = countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAll()
    {
        List<Country> countries = countryService.getAll();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> get(@PathVariable("id") Long id,
                                       @RequestParam(value = "name", required = true) String name,
                                       @RequestParam(value = "age", required = false) String age)
    {
        System.out.println(name);
        System.out.println(age);
        Country country = countryService.get(id);
        return ResponseEntity.ok(country);
    }


}
