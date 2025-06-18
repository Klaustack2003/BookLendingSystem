package com.cg.training.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link InvalidLoanException}.
 * 
 * This test verifies that the exception correctly stores and returns
 * the message passed to its constructor.
 * 
 * @see InvalidLoanException
 * 
 * @author Subhadip Das
 */
class InvalidLoanExceptionTest {

    @Test void messageStored() {
        String msg = "Bad loan";
        InvalidLoanException ex = new InvalidLoanException(msg);
        assertEquals(msg, ex.getMessage());
    }
}
