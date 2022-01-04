package com.example.moviesearch.service;

import com.example.moviesearch.dto.MovieRequest;
import com.example.moviesearch.dto.MovieResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenApiServiceTest {

    @Autowired
    private OpenApiService openApiService;

    @Test
    void openApiServiceTest(){
        var searchMovie = new MovieRequest();
        searchMovie.setQuery("신세계");

        var result = openApiService.searchMovie(searchMovie);

        System.out.println(result);
    }

}