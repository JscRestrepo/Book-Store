package com.books.system.controller;

import com.books.system.interfaces.BookService;
import com.books.system.logs.LoggerInfoApp;
import com.books.system.model.dto.BookDto;
import com.books.system.model.dto.BookPageDto;
import com.books.system.model.entity.Book;
import com.books.system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;
    private final LoggerInfoApp loggerInfoApp;

    @PostMapping("/book")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto book = bookService.createBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/rated/books")
    public ResponseEntity<Page<Object[]>> getRatedBooks() {
        return new ResponseEntity<>(bookService.getTopRatedBooksOfWeek(), HttpStatus.OK);
    }
}
