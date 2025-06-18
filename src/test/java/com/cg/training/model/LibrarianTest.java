// src/test/java/com/cg/training/model/LibrarianTest.java
package com.cg.training.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the {@link Librarian} class.
 * 
 * This test verifies the following:
 * <ul>
 *   <li>Librarian ID starts with the expected prefix ("L")</li>
 *   <li>{@code adminDetails()} includes the generated ID</li>
 *   <li>{@code userDetails()} returns the correct formatted string</li>
 * </ul>
 *
 * @see Librarian
 * @see Admin
 * @see User
 * 
 * @author Supriyo Pal
 */

class LibrarianTest {

	 /**
     * Tests that a {@link Librarian}:
     * <ul>
     *   <li>Has an ID starting with "L"</li>
     *   <li>Returns admin details containing the librarian ID</li>
     *   <li>Returns correct user details string</li>
     * </ul>
     */
	
    @Test void idsAndDetails() {
        Librarian l = new Librarian("Lib", "l@l.com");
        assertTrue(l.getLibrarianId().startsWith("L"));
        assertTrue(l.adminDetails().contains(l.getLibrarianId()));
        assertEquals("Name: Lib | Email: l@l.com", l.userDetails());
    }
}
