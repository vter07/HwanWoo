package com.example.moviesearch.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieSearchServiceTest {

    @Autowired
    private MovieSearchService movieSearchService;

    @Test
    void search() {
        var result = movieSearchService.search("태극기");
        System.out.println(result);
    }
}