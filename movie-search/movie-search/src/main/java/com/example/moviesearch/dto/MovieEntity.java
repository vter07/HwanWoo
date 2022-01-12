package com.example.moviesearch.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 제목

    private String link; // 영화 하이퍼텍스트 링크

    private String image; // 이미지 URL

    private String subtitle; // 부제목

    private String pubDate; // 개봉년도

    private String director; // 감독

    private String actor; // 배우

    private Double userRating; // 평점

    private boolean isWatched; // 시청 여부

    private int watchCount; // 시청 횟수

    private LocalDateTime lastWatchedDate; // 마지막 시청 날짜
}
