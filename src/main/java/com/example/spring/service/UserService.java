package com.example.spring.service;

import com.example.spring.model.User;

public interface UserService
{
    void save(User user);

    User findByName(String name);
}
