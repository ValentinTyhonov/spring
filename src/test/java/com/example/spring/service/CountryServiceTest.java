package com.example.spring.service;

import com.example.spring.model.Country;
import com.example.spring.repository.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryServiceTest
{
    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryServiceImpl countryService;

    @Test
    @DisplayName("Get all countries")
    public void testGetAll()
    {
        when(countryRepository.findAll(any(Sort.class))).thenReturn(Collections.singletonList(new Country()));

        List<Country> countries = countryService.getAll();

        assertFalse(countries.isEmpty());
    }

    @Test
    @DisplayName("Get one country by ID")
    public void testGetOne()
    {
        when(countryRepository.getOne(anyLong())).thenReturn(new Country("Ukraine", 232314L));

        Country country = countryService.get(2L);

        assertEquals("Ukraine", country.getName());
    }

    @Test
    @DisplayName("Delete country that not exists")
    public void testDeleteThatNotExists()
    {
        when(countryRepository.existsById(anyLong())).thenReturn(false);

//        verify(countryRepository, never()).deleteById(anyLong());

        assertThrows(IOException.class, () -> countryService.delete(1L));
    }

    @DisplayName("Delete country")
    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, 4L, Long.MAX_VALUE})
    public void testDelete(long number)
    {
        when(countryRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(countryRepository).deleteById(anyLong());

//        verify(countryRepository, times()).deleteById(anyLong());

        assertThrows(IOException.class, () -> countryService.delete(number), "Failed");
    }
}
