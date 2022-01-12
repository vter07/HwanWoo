package com.example.moviesearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResultDto {
    private String title;

    private String link; // 영화 하이퍼텍스트 링크

    private String image; // 이미지 URL

    private String subtitle;

    private String pubDate;

    private String director;

    private String actor;

    private Double userRating;
}
