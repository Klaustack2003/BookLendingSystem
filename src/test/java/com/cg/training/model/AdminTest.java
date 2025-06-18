// src/test/java/com/cg/training/model/AdminTest.java
package com.cg.training.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the {@link Admin} class.
 * 
 * This test ensures that the {@code userDetails()} method, inherited from {@link User},
 * is correctly implemented in the {@code Admin} class.
 * 
 * @see Admin
 * @see User
 * 
 * @author Supriyo Pal
 */

class AdminTest {
	
	/**
     * Verifies that an {@link Admin} instance returns the expected user details
     * string format via the {@code userDetails()} method.
     * <p>Expected format: {@code "Name: <name> | Email: <email>"}</p>
     */
	
    @Test void inheritsUserDetails() {
        Admin a = new Admin("N", "e@x.com");
        assertEquals("Name: N | Email: e@x.com", a.userDetails());
    }
}
