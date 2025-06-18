package com.cg.training.daoImplementation;

import com.cg.training.dao.MemberDAO;
import com.cg.training.model.Member;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MemberDAOImplementation provides an in-memory implementation of the 
 * {@link MemberDAO} interface for managing member data.
 * <p>
 * This implementation stores members in a list without persistence.
 * </p>
 * 
 * @author Jayashree Roy
 */
public class MemberDAOImplementation implements MemberDAO {

    /**
     * Internal list to store member records.
     */
    private final List<Member> members = new ArrayList<>();

    /**
     * Adds a new Member to the internal list.
     *
     * @param member the Member object to be added; must not be null
     * @throws IllegalArgumentException if the member is null
     */
    @Override
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        members.add(member);
    }

    /**
     * Searches for a member by their unique ID.
     *
     * @param id the member ID to search for; must not be null or empty
     * @return an Optional containing the Member if found, or empty if no match is found
     * @throws IllegalArgumentException if the id is null or empty
     */
    @Override
    public Optional<Member> findMemberById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }

        return members.stream()
                      .filter(m -> m.getMemberId().equalsIgnoreCase(id))
                      .findFirst();
    }

    /**
     * Retrieves all members currently stored.
     *
     * @return an unmodifiable List of Member objects; may be empty if no members exist
     */
    @Override
    public List<Member> getAllMembers() {
        return Collections.unmodifiableList(members);
    }
}
