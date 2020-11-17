package com.example.spring.service;

import com.example.spring.model.Role;
import com.example.spring.model.User;
import com.example.spring.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService
{
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder)
    {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user)
    {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        log.info("Stored user {}", user.getUsername());
    }

    @Override
    public User findByName(String name)
    {
        log.info("Looking for user with name " + name);
        return repository.findByUsername(name);
    }
}
