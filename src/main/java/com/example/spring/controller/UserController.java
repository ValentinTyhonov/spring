package com.example.spring.controller;

import com.example.spring.model.User;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController
{
    private UserService service;

    @Autowired
    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "registration";
        }

        service.save(user);

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String logout, String error)
    {
        if (error != null)
        {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null)
        {
            model.addAttribute("message", "You have been logged out.");
        }

        return "login";
    }

    @GetMapping( {"/", "/welcome"})
    public String welcome()
    {
        return "welcome";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }

    @GetMapping("/anonymous")
    public String anonymous()
    {
        return "anonymous";
    }

    @GetMapping("/access-denied")
    public String accessDenied()
    {
        return "access-denied";
    }
}
