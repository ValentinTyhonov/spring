package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "country")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonIgnore
    private long id;
    @Column(name = "name_of_country")
    private String name;
    @Column(name = "population")
    private long population;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    private Capital capital;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<City> cities;

    public Country(String name, long population)
    {
        this.name = name;
        this.population = population;
    }

    public Country(long id, String name, long population)
    {
        this.id = id;
        this.name = name;
        this.population = population;
    }
}