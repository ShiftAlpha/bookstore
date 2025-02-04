package com.bookstore.service;

// Import necessary testing libraries
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the BookService class.
 */
class BookServiceTest {

    // Mock the BookRepository to isolate testing from the database
    private final BookRepository bookRepository = mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);

    /**
     * Test case for creating a new book.
     * - Ensures that a book is created and returned correctly.
     * - Uses Mockito to mock repository behavior.
     */
    @Test
    void testCreateBook() {
        // Arrange: Create a book object (ISBN will be generated)
        Book book = new Book("Test Book", "Author", null);

        // Mock repository behavior: return the same book when saved
        when(bookRepository.save(any())).thenReturn(book);

        // Act: Call createBook() from the service
        Book savedBook = bookService.createBook(book);

        // Assert: Validate that the book was created successfully
        assertNotNull(savedBook);  // Ensure book is not null
        assertEquals("Test Book", savedBook.getTitle());  // Check title
    }

    /**
     * Test case for retrieving a book by ID.
     * - Ensures that the correct book is returned when found.
     * - Uses Mockito to mock repository behavior.
     */
    @Test
    void testGetBookById() {
        // Arrange: Create a book with an ID and ISBN
        Book book = new Book("Test Book", "Author", "9781234567890");

        // Mock repository behavior: return the book when findById() is called with ID 1
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        // Act: Call getBookById() from the service
        Book foundBook = bookService.getBookById(1L);

        // Assert: Validate that the correct book is returned
        assertEquals("Test Book", foundBook.getTitle());  // Check title
    }
}
