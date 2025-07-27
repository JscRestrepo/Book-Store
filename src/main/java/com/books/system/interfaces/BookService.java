package com.books.system.interfaces;

import com.books.system.model.dto.BookDto;
import com.books.system.model.dto.BookPageDto;
import com.books.system.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<Book> getAllBooks();
    Page<Object[]> getTopRatedBooksOfWeek();
}
