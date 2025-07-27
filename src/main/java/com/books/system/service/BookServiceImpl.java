package com.books.system.service;

import com.books.system.exception.BookExistingException;
import com.books.system.interfaces.BookService;
import com.books.system.logs.LoggerInfoApp;
import com.books.system.model.dto.BookDto;
import com.books.system.model.dto.BookPageDto;
import com.books.system.model.entity.Book;
import com.books.system.model.mapper.BookMapper;
import com.books.system.repository.BookRepository;
import com.books.system.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final ScoreRepository scoreRepository;
    private final LoggerInfoApp loggerInfoApp;

    @Override
    public BookDto createBook(BookDto bookDto) {
        boolean bookExists = bookRepository.existsByBookCode(bookDto.bookCode());

        if (bookExists) {
            throw new BookExistingException("The book with " + bookDto.bookCode() + " code already exists");
        }

        Book book = bookMapper.dtoToEntity(bookDto);
        bookRepository.save(book);

        loggerInfoApp.BookCreatedLog(book.getTitle());
        return bookMapper.entityToDto(book);

    }

    @Override
    @Cacheable(value = "books")
    public List<Book> getAllBooks() {
        List<Book> result = bookRepository.findAll();
        printLogBooks(result);

        return result;
    }

    private void printLogBooks(List<Book> result) {
        List<String> title = result
                .stream()
                .map(Book::getTitle)
                .toList();

        loggerInfoApp.PrintLogBooks(title);
    }

    @Override
    public Page<Object[]> getTopRatedBooksOfWeek() {
        Pageable topFive = PageRequest.of(0, 5);
        return scoreRepository.findTopRatedBooksOfWeek(topFive);
    }
}
