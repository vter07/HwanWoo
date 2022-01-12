package com.example.moviesearch.dto;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieResponse {

    private Date lastBuildDate;

    private List<MovieItem> items;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MovieItem{
        private String title;

        private String link;

        private String image;

        private String subtitle;

        private String pubDate;

        private String director;

        private String actor;

        private Double userRating;
    }
}
