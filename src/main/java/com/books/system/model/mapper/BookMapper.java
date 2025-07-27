package com.books.system.model.mapper;

import com.books.system.model.dto.BookDto;
import com.books.system.model.entity.Book;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class BookMapper {

    public Book dtoToEntity(BookDto bookDto) {
        return Book.builder()
                .bookId(bookDto.bookId())
                .title(bookDto.title())
                .bookCode(bookDto.bookCode())
                .author(bookDto.author())
                .price(bookDto.price())
                .build();
    }

    public BookDto entityToDto(Book book) {
        return new BookDto(
                book.getBookId(),
                book.getTitle(),
                book.getBookCode(),
                book.getAuthor(),
                book.getPrice()
        );
    }
}
