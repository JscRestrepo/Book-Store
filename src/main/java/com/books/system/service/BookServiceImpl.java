package com.books.system.service;

import com.books.system.exception.BookExistingException;
import com.books.system.interfaces.BookService;
import com.books.system.model.dto.BookDto;
import com.books.system.model.entity.Book;
import com.books.system.model.mapper.BookMapper;
import com.books.system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper  bookMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        boolean bookExists = bookRepository.existsByBookCode(bookDto.bookCode());

        if (bookExists) {
            throw new BookExistingException("The book with " + bookDto.bookCode() + " code already exists");
        }

        Book book = bookMapper.dtoToEntity(bookDto);
        bookRepository.save(book);
        return bookMapper.entityToDto(book);

    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
