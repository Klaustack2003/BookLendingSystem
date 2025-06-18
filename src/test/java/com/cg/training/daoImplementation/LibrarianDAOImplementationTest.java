// src/test/java/com/cg/training/daoImplementation/LibrarianDAOImplementationTest.java
package com.cg.training.daoImplementation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Librarian;

/**
 * Unit test for {@link LibrarianDAOImplementation}.
 * 
 * This test verifies the correct behavior of adding and retrieving librarians
 * and ensures that the list returned by {@code getAllLibrarians()} is unmodifiable.
 * 
 * Contracts tested:
 * <ul>
 *   <li>A librarian can be successfully added and retrieved.</li>
 *   <li>The returned list of librarians is unmodifiable.</li>
 * </ul>
 * 
 * This test ensures internal consistency and immutability of the exposed data structure.
 * 
 * @see Librarian
 * @see LibrarianDAOImplementation
 * 
 * @author Subhadip Das
 */

class LibrarianDAOImplementationTest {

	/**
     * Tests the addition of a librarian and ensures that:
     * <ul>
     *   <li>The added librarian is present in the list returned by {@code getAllLibrarians()}.</li>
     *   <li>The list returned is unmodifiable (modification should throw {@link UnsupportedOperationException}).</li>
     * </ul>
     */
	
    @Test void addAndGet() {
        LibrarianDAOImplementation dao = new LibrarianDAOImplementation();
        Librarian lib = new Librarian("Lib", "lib@x.com");
        dao.addLibrarian(lib);
        assertEquals(Arrays.asList(lib), dao.getAllLibrarians());
        assertThrows(UnsupportedOperationException.class,
                     () -> dao.getAllLibrarians().add(new Librarian("X","y")));
    }
}
