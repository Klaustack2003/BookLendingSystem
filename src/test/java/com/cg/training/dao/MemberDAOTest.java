package com.cg.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Member;

/**
 * Unit test for {@link MemberDAO}. This test verifies the fundamental
 * operations of adding a member and retrieving a member by ID.
 * 
 * The following contract is tested:
 * <ul>
 *   <li>A member can be added to the DAO.</li>
 *   <li>A member can be retrieved by their ID.</li>
 * </ul>
 * 
 * An in-memory list is used to mock data persistence.
 * 
 * @author Subhadip Das
 */

class MemberDAOTest {

	/**
     * Tests the contract of the {@link MemberDAO} interface.
     * Ensures that members can be added and retrieved by their ID.
     */
	
    @Test void contract() {
        List<Member> list = new ArrayList<>();
        MemberDAO dao = new MemberDAO() {
            public void addMember(Member m){ list.add(m); }
            public Optional<Member> findMemberById(String id){ return list.stream().filter(x->x.getMemberId().equals(id)).findFirst(); }
            public List<Member> getAllMembers(){ return list; }
        };
        Member m = new Member("Z","z@z");
        dao.addMember(m);
        assertEquals(m, dao.findMemberById(m.getMemberId()).orElseThrow(() -> new NoSuchElementException()));
    }
}
