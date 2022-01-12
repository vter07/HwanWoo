package com.example.moviesearch.dto;


import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    private String query = "";

    private Integer display = 10;

    private Integer start = 1;

    private String genre;

    private String country = "KR";

    private Integer yearFrom = 2000;

    private Integer yearTo = 2020;

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("genre", genre);
        map.add("country", country);
        map.add("yearFrom", String.valueOf(yearFrom));
        map.add("yearTo", String.valueOf(yearTo));

        return map;
    }
}
