package com.example.moviesearch.service;

import com.example.moviesearch.dto.MovieRequest;
import com.example.moviesearch.dto.MovieResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OpenApiService {

    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.movie}")
    private String naverSearchMovieUrl;

//    @Value("${naver.url.search.image}")
//    private String naverSearchImageUrl;

    public List<MovieResponse.MovieItem> searchMovie(MovieRequest movieRequest){
        var uri = UriComponentsBuilder.fromUriString(naverSearchMovieUrl)
                .queryParams(movieRequest.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<MovieResponse>(){};


        var movieResponse = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return movieResponse.getBody().getItems();
    }
}
