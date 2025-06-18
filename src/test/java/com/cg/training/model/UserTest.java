// src/test/java/com/cg/training/model/UserTest.java
package com.cg.training.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Temporary concrete subclass used solely for testing the abstract {@link User} class.
 * Provides a minimal constructor to enable instantiation for unit testing.
 * 
 * @author Subhadip Das
 */

class Tmp extends User { Tmp() { super("A","a@b.com"); } }

/**
 * Unit test for the abstract {@link User} class.
 * 
 * This test verifies:
 * <ul>
 *   <li>That {@code userDetails()} returns the correct string format for a user's name and email</li>
 * </ul>
 * 
 * @see User
 * @see Tmp
 * @author Subhadip Das
 */

class UserTest {
	
	/**
     * Tests the {@code userDetails()} method to ensure it outputs the correct
     * format: {@code Name: [name] | Email: [email]}.
     */
	
    @Test void details() {
        User u = new Tmp();
        assertEquals("Name: A | Email: a@b.com", u.userDetails());
    }
}
