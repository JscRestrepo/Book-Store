package com.books.system.model.mapper;

import com.books.system.model.dto.BookRatingDto;
import com.books.system.model.entity.Book;
import com.books.system.model.entity.BookRating;
import com.books.system.model.entity.User;
import com.books.system.repository.BookRepository;
import com.books.system.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Builder
public class RatingMapper {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookRating dtoToEntity(BookRatingDto bookRatingDto) {
        Book book = bookRepository.findById(bookRatingDto.book())
                .orElseThrow(() ->
                        new RuntimeException("Boot not found")
        );

        User user = userRepository.findById(bookRatingDto.user())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return BookRating.builder()
                .ratingId(bookRatingDto.ratingId())
                .book(book)
                .score(bookRatingDto.score())
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
    }

    public BookRatingDto entityToDto(BookRating bookRating) {
        return new BookRatingDto(
                bookRating.getRatingId(),
                bookRating.getBook().getBookId(),
                bookRating.getScore(),
                LocalDateTime.now(),
                bookRating.getUser().getUserId());
    }
}
