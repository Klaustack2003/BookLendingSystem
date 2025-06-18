// src/test/java/com/cg/training/daoImplementation/MemberDAOImplementationTest.java
package com.cg.training.daoImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Member;

/**
 * Unit test for {@link MemberDAOImplementation}.
 * 
 * This test verifies that:
 * <ul>
 *   <li>A member can be added to the DAO</li>
 *   <li>The member can be retrieved by ID</li>
 *   <li>The full list of members includes the added member</li>
 * </ul>
 * 
 * This ensures the core functionality of the MemberDAO is working as expected.
 * 
 * @see Member
 * @see MemberDAOImplementation
 * 
 * @author Subhadip Das
 */

class MemberDAOImplementationTest {

	/**
     * Tests adding a member, finding them by ID, and retrieving all members.
     * Ensures:
     * <ul>
     *   <li>The added member is present in the DAO</li>
     *   <li>The {@code findMemberById} method returns the correct result</li>
     *   <li>The {@code getAllMembers} method returns the correct list</li>
     * </ul>
     */
	
    @Test void addFindGet() {
        MemberDAOImplementation dao = new MemberDAOImplementation();
        Member m = new Member("A", "a@a.com");
        dao.addMember(m);

        assertTrue(dao.findMemberById(m.getMemberId()).isPresent());
        assertEquals(Arrays.asList(m), dao.getAllMembers());
    }
}
