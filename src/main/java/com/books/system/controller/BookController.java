package com.books.system.controller;

import com.books.system.interfaces.BookService;
import com.books.system.model.dto.BookDto;
import com.books.system.model.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create-book")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto book = bookService.createBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/get-books")
    public ResponseEntity<Page<Book>> getAllBooks(Pageable pageable) {
        return new ResponseEntity<>(bookService.getAllBooks(pageable), HttpStatus.OK);
    }
}
