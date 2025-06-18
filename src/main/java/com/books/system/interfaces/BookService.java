package com.books.system.interfaces;

import com.books.system.model.dto.BookDto;
import com.books.system.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    Page<Book> getAllBooks(Pageable pageable);
}
