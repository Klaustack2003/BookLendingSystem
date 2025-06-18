// src/test/java/com/cg/training/daoImplementation/BookDAOImplementationTest.java
package com.cg.training.daoImplementation;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.*;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

import com.cg.training.model.Book;

/**
 * Unit tests for {@link BookDAOImplementation}. 
 * 
 * This test class verifies the behavior of the book data access object implementation, 
 * including book addition, removal, search, and persistence to file storage.
 * 
 * Contracts tested:
 * <ul>
 *   <li>Books can be added and retrieved.</li>
 *   <li>Adding a duplicate book title increments the count, instead of creating duplicates.</li>
 *   <li>Books can be removed by decrementing their count.</li>
 *   <li>A book becomes unavailable when its count reaches zero.</li>
 *   <li>Books are correctly persisted to and reloaded from a file.</li>
 *   <li>The returned book list is unmodifiable.</li>
 * </ul>
 * 
 * This test uses an actual file at {@code resources/books.txt} to test persistence.
 * 
 * @author Supriyo Pal
 */

class BookDAOImplementationTest {

    private Path file = Paths.get("resources/books.txt");

    /**
     * Deletes the book storage file before each test to ensure a clean slate.
     */
    
    @BeforeEach
    void clean() throws Exception {
        // ensure a clean slate before each test
        Files.deleteIfExists(file);
    }

    /**
     * Tests the complete contract of book handling including:
     * <ul>
     *   <li>Adding books and incrementing count on duplicate titles.</li>
     *   <li>Case-insensitive search.</li>
     *   <li>Availability status handling.</li>
     *   <li>Persistence of books to and from file.</li>
     * </ul>
     */
    
    @Test
    void addFindRemovePersistence() throws Exception {
        BookDAOImplementation dao = new BookDAOImplementation();

        // add new book
        Book b1 = new Book("Title", "Author", 2);
        dao.addBook(b1);
        assertEquals(1, dao.getAllBooks().size());
        assertTrue(dao.findBookByTitle("title").isPresent()); // case‑insensitive

        // add same title again increments count, doesn’t create duplicate
        dao.addBook(new Book("Title", "Author", 3)); // +3 copies
        Book loaded = dao.findBookByTitle("Title").orElseThrow(() -> new NoSuchElementException());
        assertEquals(5, loaded.getCount());

        // remove copies
        dao.removeBook("Title");             // single decrement
        assertEquals(4, loaded.getCount());
        assertTrue(loaded.isAvailable());

        // decrement until zero → available=false
        for (int i=0;i<4;i++) dao.removeBook("Title");
        assertFalse(loaded.isAvailable());
        assertEquals(0, loaded.getCount());

        // persistence
        assertTrue(Files.exists(file));
        BookDAOImplementation reload = new BookDAOImplementation();
        Book persisted = reload.findBookByTitle("Title").orElseThrow(() -> new NoSuchElementException());
        assertEquals(0, persisted.getCount());
        assertFalse(persisted.isAvailable());
    }

    /**
     * Ensures that the list of books returned is unmodifiable.
     * Attempting to modify it should throw an {@link UnsupportedOperationException}.
     */
    
    @Test
    void unmodifiableList() {
        BookDAOImplementation dao = new BookDAOImplementation();
        assertThrows(UnsupportedOperationException.class,
                     () -> dao.getAllBooks().add(new Book("x","y",1)));
    }
}
