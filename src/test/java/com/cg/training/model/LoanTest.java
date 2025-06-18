// src/test/java/com/cg/training/model/LoanTest.java
package com.cg.training.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the {@link Loan} class.
 * 
 * This test verifies the behavior of a loan throughout its lifecycle, including:
 * <ul>
 *   <li>Correct initialization of loan status and book availability</li>
 *   <li>Integrity of the loan detail summary</li>
 *   <li>State changes when the loan is completed</li>
 * </ul>
 *
 * @see Loan
 * @see Book
 * @see Member
 * 
 * @author Subhadip Das
 */

class LoanTest {

	/**
     * Tests the full lifecycle of a {@link Loan}:
     * <ul>
     *   <li>Loan creation updates status to "Borrowed" and marks the book as unavailable</li>
     *   <li>{@code loanDetails()} contains relevant information</li>
     *   <li>Completing the loan updates status to "Returned" and makes the book available again</li>
     * </ul>
     */
	
    @Test
    void loanLifecycle() {
        Member member = new Member("Alice", "alice@books.com");
        Book book   = new Book("1984", "George Orwell", 1);

        // create loan → book becomes unavailable and status “Borrowed”
        Loan loan = new Loan(member, book);
        assertEquals(member, loan.getMember());
        assertEquals(book,   loan.getBook());
        assertEquals("Borrowed", loan.getStatus());
        assertFalse(book.isAvailable());

        // loanDetails contains all pieces of info
        String details = loan.loanDetails();
        assertTrue(details.contains(member.getMemberId()) || details.contains(member.userDetails()));
        assertTrue(details.contains(book.getTitle()));
        assertTrue(details.contains("Borrowed"));

        // complete loan → status “Returned” and book available
        loan.completeLoan();
        assertEquals("Returned", loan.getStatus());
        assertTrue(book.isAvailable());
    }
}
