package com.cg.training.dao;

import com.cg.training.model.Member;

import java.util.List;
import java.util.Optional;

/**
 * MemberDAO is a Data Access Object interface for managing operations 
 * related to Member entities, such as adding a member, finding a member 
 * by ID, and retrieving all members.
 * <p>
 * Implementations of this interface handle persistence and retrieval 
 * logic for Member records in the system.
 * </p>
 * 
 * @author Jayashree Roy
 */
public interface MemberDAO {

    /**
     * Adds a new Member to the data source.
     *
     * @param member the Member object to be added; must not be null
     * @throws IllegalArgumentException if the member is null or contains invalid data
     */
    void addMember(Member member);

    /**
     * Finds and retrieves a Member from the data source by their unique ID.
     *
     * @param id the unique identifier of the member; must not be null or empty
     * @return an Optional containing the found Member, or empty if no member with the given ID exists
     * @throws IllegalArgumentException if the ID is null or empty
     */
    Optional<Member> findMemberById(String id);

    /**
     * Retrieves all Members from the data source.
     *
     * @return a List of Member objects; may be empty if no members are found
     */
    List<Member> getAllMembers();
}
