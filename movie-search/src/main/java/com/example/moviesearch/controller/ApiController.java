package com.example.moviesearch.controller;

import com.example.moviesearch.dto.MovieResponse;
import com.example.moviesearch.dto.SearchResultDto;
import com.example.moviesearch.service.MovieSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class ApiController {

    private final MovieSearchService movieSearchService;

    @GetMapping("/search")
    public MovieResponse search(String query){
        return movieSearchService.search(query);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
