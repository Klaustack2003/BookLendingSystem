package com.cg.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.cg.training.model.User;
import com.cg.training.model.Member;

/**
 * Unit test for {@link UserDAO}. This test verifies the basic
 * functionality for managing users, specifically adding a user
 * and retrieving the list of users.
 * 
 * The test uses a mock implementation backed by an in-memory list.
 * 
 * Tested contract:
 * <ul>
 *   <li>A user can be added via the {@code addUser} method.</li>
 *   <li>All added users are returned correctly from {@code getAllUsers}.</li>
 * </ul>
 * 
 * In this test, a {@link Member} (which extends {@link User}) is used.
 * 
 * @author Supriyo Pal
 */

class UserDAOTest {

	/**
     * Tests the contract of the {@link UserDAO} interface.
     * Verifies that a user can be added and retrieved correctly.
     */
	
    @Test void contract() {
        List<User> list = new ArrayList<>();
        UserDAO dao = new UserDAO() {
            public void addUser(User u){ list.add(u); }
            public List<User> getAllUsers(){ return list; }
        };
        User u = new Member("U","u@u");
        dao.addUser(u);
        assertEquals(Arrays.asList(u), dao.getAllUsers());
    }
}
