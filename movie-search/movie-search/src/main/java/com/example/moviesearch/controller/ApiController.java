package com.example.moviesearch.controller;

import com.example.moviesearch.dto.MovieEntity;
import com.example.moviesearch.dto.MovieResponse;
import com.example.moviesearch.dto.SearchResultDto;
import com.example.moviesearch.repository.MovieEntityRepository;
import com.example.moviesearch.service.MovieSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class ApiController {

    private final MovieSearchService movieSearchService;
    private final MovieEntityRepository movieEntityRepository;

    @GetMapping("/search")
    public List<SearchResultDto> search(String query){
        return movieSearchService.search(query);
    }

    @PostMapping("")
    public MovieEntity add(@RequestBody MovieResponse.MovieItem movieItem){
        return movieEntityRepository.save(movieSearchService.responseToEntity(movieItem));
    }

    @GetMapping("/all")
    public List<MovieEntity> findAll(){
        return movieEntityRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        movieEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAll(){
        movieEntityRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public void addWatch(@PathVariable Long id) {
        movieSearchService.addWatch(id);
    }






}
