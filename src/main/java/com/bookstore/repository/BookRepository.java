package com.bookstore.repository;

// Import necessary Spring Data JPA and repository annotations
import com.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Book entities.
 * 
 * - Extends JpaRepository, providing CRUD operations.
 * - Spring automatically generates implementation at runtime.
 */
@Repository  // Marks this interface as a Spring Data repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Checks if a book with the given ISBN already exists in the database.
     * 
     * - Spring Data JPA will automatically generate the query from method name.
     * - Returns true if a book with the given ISBN exists, otherwise false.
     * 
     * @param isbn The ISBN to check.
     * @return True if a book with the given ISBN exists, false otherwise.
     */
    boolean existsByIsbn(String isbn);
}
