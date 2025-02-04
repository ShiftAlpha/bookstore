package com.bookstore.controller;

// Import necessary classes for handling HTTP requests and responses
import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing book-related API endpoints.
 */
@RestController  // Marks this class as a REST API controller
@RequestMapping("/api/books")  // Base URL for all endpoints in this controller
public class BookController {

    // Dependency injection for the BookService (handles business logic)
    private final BookService bookService;

    /**
     * Constructor-based dependency injection for BookService.
     * @param bookService the service that handles book operations.
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * GET /api/books
     * Retrieves a list of all books in the database.
     * @return List of all books.
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();  // Calls service layer to get all books
    }

    /**
     * GET /api/books/{id}
     * Retrieves a book by its ID.
     * @param id the ID of the book to fetch.
     * @return ResponseEntity containing the book if found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    /**
     * POST /api/books
     * Creates a new book entry in the database.
     * @param book the book object to be created.
     * @return ResponseEntity containing the created book.
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    /**
     * PUT /api/books/{id}
     * Updates an existing book in the database.
     * @param id the ID of the book to update.
     * @param updatedBook the book object containing updated data.
     * @return ResponseEntity containing the updated book.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book updatedBook) {
        return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
    }

    /**
     * DELETE /api/books/{id}
     * Deletes a book from the database.
     * @param id the ID of the book to delete.
     * @return ResponseEntity with no content if deletion is successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();  // Returns HTTP 204 (No Content)
    }
}
