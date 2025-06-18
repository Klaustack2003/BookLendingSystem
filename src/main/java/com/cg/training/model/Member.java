package com.cg.training.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a Member user in the system.
 * <p>
 * Extends the {@link User} class and adds a unique member ID generated automatically.
 * </p>
 * 
 * @author Deeptangshu Saha
 */
public class Member extends User {
    /**
     * Atomic counter to generate unique member IDs.
     */
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    /**
     * Unique identifier for the member, formatted as "M" followed by a zero-padded number.
     */
    private final String memberId;

    /**
     * Constructs a new Member with the specified name and email.
     * Generates a unique member ID.
     * 
     * @param name  the name of the member
     * @param email the email address of the member
     */
    public Member(String name, String email) {
        super(name, email);
        this.memberId = String.format("M%03d", idCounter.getAndIncrement());
    }

    /**
     * Returns the unique member ID.
     * 
     * @return the member's unique ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * Returns a string representing user details (name and email).
     * Overrides the base class method and hides the ID.
     * 
     * @return formatted user details string
     */
    @Override
    public String userDetails() {
        return String.format("Name: %s | Email: %s", name, email);
    }

    /**
     * Returns a string representing member details including member ID and user details.
     * 
     * @return formatted member details string
     */
    public String adminDetails() {
        return String.format("Member ID: %s | %s", memberId, userDetails());
    }
}
