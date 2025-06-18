// src/test/java/com/cg/training/model/MemberTest.java
package com.cg.training.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for the {@link Member} class.
 * 
 * This test validates the behavior of the {@code Member} class, specifically:
 * <ul>
 *   <li>That member IDs are auto-generated with the correct prefix</li>
 *   <li>That {@code adminDetails()} includes the member's ID</li>
 *   <li>That {@code userDetails()} returns a properly formatted string</li>
 * </ul>
 *
 * @see Member
 * @see User
 * @see Admin
 * 
 * @author Supriyo Pal
 */

class MemberTest {

	/**
     * Verifies that a {@link Member}:
     * <ul>
     *   <li>Has an ID starting with "M"</li>
     *   <li>Returns admin details containing the member ID</li>
     *   <li>Returns correct user detail formatting</li>
     * </ul>
     */
	
    @Test void idsAndDetails() {
        Member m = new Member("Mem", "m@x.com");
        assertTrue(m.getMemberId().startsWith("M"));
        assertTrue(m.adminDetails().contains(m.getMemberId()));
        assertEquals("Name: Mem | Email: m@x.com", m.userDetails());
    }
}
