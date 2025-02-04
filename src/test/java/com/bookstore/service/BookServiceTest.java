package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private final BookRepository bookRepository = mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);

    @Test
    void testCreateBook() {
        Book book = new Book("Test Book", "Author", null);
        when(bookRepository.save(any())).thenReturn(book);
        Book savedBook = bookService.createBook(book);
        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
    }

    @Test
    void testGetBookById() {
        Book book = new Book("Test Book", "Author", "9781234567890");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book foundBook = bookService.getBookById(1L);
        assertEquals("Test Book", foundBook.getTitle());
    }
}
