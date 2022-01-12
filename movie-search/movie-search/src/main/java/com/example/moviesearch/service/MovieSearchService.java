package com.example.moviesearch.service;

import com.example.moviesearch.dto.MovieEntity;
import com.example.moviesearch.dto.MovieRequest;
import com.example.moviesearch.dto.MovieResponse;
import com.example.moviesearch.dto.SearchResultDto;
import com.example.moviesearch.repository.MovieEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieSearchService {

    private final OpenApiService openApiService;
    private final MovieEntityRepository movieEntityRepository;

    public List<SearchResultDto> search(String query){
        var movieRequest = new MovieRequest();
        movieRequest.setQuery(query);

        List<SearchResultDto> searchResults = new ArrayList<>();

        var movieResponse = openApiService.searchMovie(movieRequest);
        movieResponse.forEach(s -> searchResults.add(responseToDto(s))
                );

        return searchResults;
    }

    public SearchResultDto add(MovieResponse.MovieItem movieItem) {
        // db에 저장
        var entity = responseToEntity(movieItem);
        var saveEntity = movieEntityRepository.save(entity);
        return entityToDto(saveEntity);
    }
    public List<SearchResultDto> findAll() {

        return movieEntityRepository.findAll()
                .stream()
                .map(it -> entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(Long index) {
        movieEntityRepository.deleteById(index);
    }

    public void addWatch(Long index) {
        var wishItem = movieEntityRepository.findById(index);
        if (wishItem.isPresent()) {
            var item = wishItem.get();
            item.setWatched(true);
            item.setWatchCount(item.getWatchCount() + 1);
        }
    }

    public SearchResultDto responseToDto(MovieResponse.MovieItem movieItem){
        var searchResultDto = SearchResultDto
                .builder()
                .actor(movieItem.getActor())
                .director(movieItem.getDirector())
                .link(movieItem.getLink())
                .image(movieItem.getImage())
                .pubDate(movieItem.getPubDate())
                .title(movieItem.getTitle())
                .subtitle(movieItem.getSubtitle())
                .userRating(movieItem.getUserRating())
                .build();
        return searchResultDto;
    }

    public MovieEntity responseToEntity(MovieResponse.MovieItem movieItem){
        var movieEntity = MovieEntity
                .builder()
                .actor(movieItem.getActor())
                .director(movieItem.getDirector())
                .link(movieItem.getLink())
                .image(movieItem.getImage())
                .pubDate(movieItem.getPubDate())
                .title(movieItem.getTitle())
                .subtitle(movieItem.getSubtitle())
                .userRating(movieItem.getUserRating())
                .build();
        return movieEntity;
    }

    public SearchResultDto entityToDto(MovieEntity movieEntity){
        var searResultDto = SearchResultDto.builder()
                .actor(movieEntity.getActor())
                .director(movieEntity.getDirector())
                .link(movieEntity.getLink())
                .image(movieEntity.getImage())
                .title(movieEntity.getTitle())
                .subtitle(movieEntity.getSubtitle())
                .pubDate(movieEntity.getPubDate())
                .userRating(movieEntity.getUserRating())
                .build();
        return searResultDto;
    }
}
