package com.example.spring.controller;

import com.example.spring.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class CountryMvcController
{
    private CountryService countryService;

    CountryMvcController(@Autowired CountryService countryService)
    {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public ModelAndView getAll()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("countries", countryService.getAll());
        return mv;
    }

}
