package com.cg.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Librarian;

/**
 * Unit test for {@link LibrarianDAO}. This test verifies the core
 * functionalities of adding and retrieving librarians using a
 * mock implementation.
 * 
 * The following contract is tested:
 * <ul>
 *   <li>Adding a librarian results in the librarian being stored.</li>
 *   <li>Retrieving all librarians returns the correct list.</li>
 * </ul>
 * 
 * A simple in-memory list is used to simulate the data store.
 * 
 * @author Subhadip Das
 */

class LibrarianDAOTest {

	/**
     * Tests the contract for the {@link LibrarianDAO} interface.
     * Ensures that a librarian can be added and retrieved correctly.
     */
	
    @Test void contract() {
        List<Librarian> list = new ArrayList<>();
        LibrarianDAO dao = new LibrarianDAO() {
            public void addLibrarian(Librarian l){ list.add(l); }
            public List<Librarian> getAllLibrarians(){ return list; }
        };
        Librarian l = new Librarian("N","e@x");
        dao.addLibrarian(l);
        assertEquals(Arrays.asList(l), dao.getAllLibrarians());
    }
}
