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
        var movieRequest = new MovieRequest();
        movieRequest.setQuery("신과 함께");

        var result = openApiService.searchMovie(movieRequest);

        System.out.println(result);
    }
}