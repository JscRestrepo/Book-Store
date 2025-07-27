package com.books.system.controller;

import com.books.system.interfaces.ScoreService;
import com.books.system.model.dto.BookRatingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping("/score")
    public ResponseEntity<BookRatingDto> createRating(@RequestBody BookRatingDto bookRatingDto) {
        BookRatingDto createRate = scoreService.createRating(bookRatingDto);
        return new ResponseEntity<>(createRate, HttpStatus.CREATED);
    }
}
