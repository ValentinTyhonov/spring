package com.example.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Developer
{
    private String name;
    private String specialty;
    private Integer experience;

    public void throwSomeMysticException()
    {
        System.out.println("We have some strange and mystic exception here:");
        throw new RuntimeException("Some mystic!");
    }
}
