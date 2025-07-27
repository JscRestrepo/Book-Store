package com.books.system.service;

import com.books.system.interfaces.ScoreService;
import com.books.system.model.dto.BookRatingDto;
import com.books.system.model.entity.BookRating;
import com.books.system.model.mapper.RatingMapper;
import com.books.system.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final RatingMapper ratingMapper;

    @Override
    public BookRatingDto createRating(BookRatingDto bookRatingDto) {
        BookRating rate = ratingMapper.dtoToEntity(bookRatingDto);
        scoreRepository.save(rate);
        return ratingMapper.entityToDto(rate);
    }
}
