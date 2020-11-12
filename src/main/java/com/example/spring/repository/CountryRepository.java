package com.example.spring.repository;

import com.example.spring.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>
{
//    List<Country> findAllByPopulatiosAndAndName(long population);

    @Query(value = "SELECT c FROM Country c")
    List<Country> findAll();

    @Query(value = "SELECT * FROM country c", nativeQuery = true)
    List<Country> findAllNative();

    @Query(value = "SELECT c FROM Country c WHERE c.name = ?1")
    List<Country> findByName(String name);

    @Query(value = "SELECT * FROM country c WHERE c.name_of_country = ?1", nativeQuery = true)
    List<Country> findByNameNative(String name);

    @Query(value = "SELECT c FROM Country c WHERE c.name IN :names")
    List<Country> findByName2(@Param("names") List<String> name);

    @Query(value = "SELECT c FROM Country c")
    Page<Country> findAll(Pageable pageable);

    @Query(value = "SELECT c FROM Country c")
    List<Country> findAllList(Pageable pageable);
}
