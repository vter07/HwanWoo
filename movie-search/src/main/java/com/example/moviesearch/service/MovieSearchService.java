package com.example.moviesearch.service;

import com.example.moviesearch.dto.MovieRequest;
import com.example.moviesearch.dto.MovieResponse;
import com.example.moviesearch.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieSearchService {

    private final OpenApiService openApiService;

    public MovieResponse search(String query){
        var movieRequest = new MovieRequest();
        movieRequest.setQuery(query);

        var movieResponse = openApiService.searchMovie(movieRequest);

        return movieResponse;
    }





}
