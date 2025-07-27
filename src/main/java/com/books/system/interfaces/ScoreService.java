package com.books.system.interfaces;

import com.books.system.model.dto.BookRatingDto;

public interface ScoreService {
    BookRatingDto createRating(BookRatingDto bookRatingDto);
}
