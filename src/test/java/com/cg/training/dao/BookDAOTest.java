package com.cg.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Book;

/**
 * Unit test for {@link BookDAO}. This test ensures that the basic contract
 * for adding, finding, and removing books is honored.
 * 
 * The test uses an anonymous inner class to implement a mock version
 * of the {@code BookDAO} interface for testing purposes.
 * 
 * The following contract is tested:
 * <ul>
 *   <li>Adding a book results in it being retrievable.</li>
 *   <li>Removing a book by title deletes it from the store.</li>
 *   <li>All books can be retrieved via {@code getAllBooks}.</li>
 * </ul>
 * 
 * @author Supriyo Pal
 */

class BookDAOTest {

	/**
     * Tests the contract for the {@link BookDAO} interface.
     * This includes adding, finding, and removing a book.
     */
	
    @Test void contract() {
        List<Book> store = new ArrayList<>();

        BookDAO dao = new BookDAO() {
            public void addBook(Book b) { store.add(b); }
            public void removeBook(String t) { store.removeIf(b -> b.getTitle().equals(t)); }
            public Optional<Book> findBookByTitle(String t){ return store.stream().filter(b->b.getTitle().equals(t)).findFirst();}
            public List<Book> getAllBooks() { return store; }
            public void saveBooksToFile() {/*no‑op*/ }
        };

        Book b = new Book("T", "A", 1);
        dao.addBook(b);
        assertEquals(b, dao.findBookByTitle("T").orElseThrow(() -> new NoSuchElementException()));
        dao.removeBook("T");
        assertTrue(dao.getAllBooks().isEmpty());
    }
}
