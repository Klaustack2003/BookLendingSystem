// src/test/java/com/cg/training/util/ValidationUtilityTest.java
package com.cg.training.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link ValidationUtility} class.
 * <p>
 * These tests verify the correctness of name, email, title, and author validations
 * using various valid and invalid inputs.
 * </p>
 * 
 * This ensures that user-provided data is correctly validated before being processed
 * by the application logic.
 * 
 * @author Supriyo Pal
 */

class ValidationUtilityTest {


    /**
     * Tests the {@link ValidationUtility#isValidName(String)} method
     * with valid and invalid name inputs.
     */
	
    @Test
    void validName() {
        assertTrue (ValidationUtility.isValidName("John Doe"));
        assertFalse(ValidationUtility.isValidName("J"));           // too short
        assertFalse(ValidationUtility.isValidName("John@Doe"));    // invalid char
    }

    /**
     * Tests the {@link ValidationUtility#isValidEmail(String)} method
     * with valid and malformed email addresses.
     */
    
    @Test
    void validEmail() {
        assertTrue (ValidationUtility.isValidEmail("a.b-c@domain.io"));
        assertFalse(ValidationUtility.isValidEmail("no-at-domain"));
    }

    /**
     * Tests the {@link ValidationUtility#isValidTitle(String)} method
     * with acceptable and empty titles.
     */
    
    @Test
    void validTitle() {
        assertTrue (ValidationUtility.isValidTitle("Good Book (2nd Ed.)"));
        assertFalse(ValidationUtility.isValidTitle(""));            // empty
    }

    /**
     * Tests the {@link ValidationUtility#isValidAuthor(String)} method
     * with valid and digit-containing author names.
     */
    
    @Test
    void validAuthor() {
        assertTrue (ValidationUtility.isValidAuthor("Isaac Asimov"));
        assertFalse(ValidationUtility.isValidAuthor("Mr. 123"));    // digits not allowed
    }
}
