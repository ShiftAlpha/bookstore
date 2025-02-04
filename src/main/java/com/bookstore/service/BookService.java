package com.bookstore.service;

// Import necessary dependencies
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.util.ISBNGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing book-related business logic.
 */
@Service  // Marks this class as a Spring service component
public class BookService {

    private final BookRepository bookRepository;  // Repository for database operations

    /**
     * Constructor-based dependency injection for BookRepository.
     * 
     * @param bookRepository the repository that manages book data.
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Retrieves all books from the database.
     * 
     * @return List of all books.
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID.
     * 
     * @param id the ID of the book.
     * @return the found book.
     * @throws RuntimeException if the book is not found.
     */
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    /**
     * Creates a new book entry in the database.
     * - Automatically generates an ISBN if not provided.
     * - Uses @Transactional to ensure database consistency.
     * 
     * @param book the book object to be created.
     * @return the saved book.
     */
    @Transactional
    public Book createBook(Book book) {
        book.setIsbn(ISBNGenerator.generateISBN());  // Auto-generate ISBN before saving
        return bookRepository.save(book);
    }

    /**
     * Updates an existing book.
     * - Retrieves the existing book from the database.
     * - Updates the title and author.
     * 
     * @param id the ID of the book to update.
     * @param updatedBook the book object with updated details.
     * @return the updated book.
     */
    @Transactional
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id);  // Ensure book exists before updating
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        return bookRepository.save(existingBook);
    }

    /**
     * Deletes a book by its ID.
     * - Uses @Transactional to ensure database integrity.
     * 
     * @param id the ID of the book to delete.
     */
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
