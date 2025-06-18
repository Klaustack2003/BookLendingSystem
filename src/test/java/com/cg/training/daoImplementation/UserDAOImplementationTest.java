// src/test/java/com/cg/training/daoImplementation/UserDAOImplementationTest.java
package com.cg.training.daoImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Member;
import com.cg.training.model.User;

/**
 * Unit test for {@link UserDAOImplementation}.
 * 
 * This test verifies that:
 * <ul>
 *   <li>A {@link User} can be successfully added to the DAO</li>
 *   <li>The {@code getAllUsers()} method returns the expected list containing the added user</li>
 * </ul>
 * 
 * The test uses a {@link Member} instance (a subclass of {@code User}) to validate polymorphic behavior.
 * 
 * @see User
 * @see Member
 * @see UserDAOImplementation
 * 
 * @author Supriyo Pal
 */

class UserDAOImplementationTest {

	/**
     * Tests that a {@link User} can be added to the DAO and retrieved via {@code getAllUsers()}.
     * Verifies:
     * <ul>
     *   <li>The added user is present in the returned list</li>
     *   <li>The list size is as expected</li>
     * </ul>
     */
	
    @Test void addGet() {
        UserDAOImplementation dao = new UserDAOImplementation();
        User u = new Member("User", "u@u.com");
        dao.addUser(u);
        assertEquals(Arrays.asList(u), dao.getAllUsers());
    }
}
