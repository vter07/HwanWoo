package com.example.moviesearch.dto;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link; // 영화 하이퍼텍스트 링크

    private String image; // 이미지 URL

    private String subtitle;

    private LocalDateTime pubDate;

    private String director;

    private String actor;

    private Integer userRating;

}
