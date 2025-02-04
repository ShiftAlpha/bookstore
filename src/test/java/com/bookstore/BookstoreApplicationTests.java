package com.bookstore;

// Import necessary Spring Boot test libraries
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Basic test class to verify that the Spring Boot application context loads correctly.
 */
@SpringBootTest  // Tells Spring Boot to load the full application context for testing
class BookstoreApplicationTests {

    /**
     * Ensures that the Spring Boot application context loads without errors.
     * - If this test passes, it means that the application's dependencies, configurations,
     *   and beans are properly set up.
     */
    @Test
    void contextLoads() {
        // This test will automatically fail if the application context cannot start
    }
}
