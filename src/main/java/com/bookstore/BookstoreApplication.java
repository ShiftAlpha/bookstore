package com.bookstore;

// Import necessary Spring Boot dependencies
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point of the Spring Boot application.
 * - This class initializes and starts the Spring Boot application.
 */
@SpringBootApplication  // Enables Spring Boot auto-configuration and component scanning
public class BookstoreApplication {

    /**
     * The main method, which starts the Spring Boot application.
     * 
     * @param args command-line arguments passed during application startup.
     */
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args); // Bootstraps the application
    }
}
