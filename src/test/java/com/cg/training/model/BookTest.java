package com.cg.training.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the {@link Book} class.
 * 
 * This test verifies key behaviors of the {@code Book} class:
 * <ul>
 *   <li>Availability toggling based on the count of copies</li>
 *   <li>Correct implementation of equality and hash code based on title and author</li>
 * </ul>
 * 
 * @see Book
 * 
 * @author Subhadip Das
 */

class BookTest {

	/**
     * Tests the following functionality of the {@link Book} class:
     * <ul>
     *   <li>Decreasing and increasing the book count affects availability</li>
     *   <li>Two books with the same title and author are considered equal</li>
     *   <li>The {@code hashCode()} method is consistent with {@code equals()}</li>
     * </ul>
     */
	
    @Test void countAndEquality() {
        Book b = new Book("T","A",2);
        b.decrementCount(); b.decrementCount();
        assertFalse(b.isAvailable());
        b.incrementCount();
        assertTrue(b.isAvailable());

        Book same = new Book("T","A",1);
        assertEquals(b, same);
        assertEquals(b.hashCode(), same.hashCode());
    }
}
