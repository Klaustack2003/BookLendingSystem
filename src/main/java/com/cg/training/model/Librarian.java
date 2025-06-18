package com.cg.training.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a Librarian user in the system.
 * <p>
 * Extends the {@link User} class and adds a unique librarian ID generated automatically.
 * </p>
 * 
 * @author Deeptangshu Saha
 */
public class Librarian extends User {
    /**
     * Atomic counter to generate unique librarian IDs.
     */
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    /**
     * Unique identifier for the librarian, formatted as "L" followed by a zero-padded number.
     */
    private final String librarianId;

    /**
     * Constructs a new Librarian with the specified name and email.
     * Generates a unique librarian ID.
     * 
     * @param name  the name of the librarian
     * @param email the email address of the librarian
     */
    public Librarian(String name, String email) {
        super(name, email);
        this.librarianId = String.format("L%03d", idCounter.getAndIncrement());
    }

    /**
     * Returns the unique librarian ID.
     * 
     * @return the librarian's unique ID
     */
    public String getLibrarianId() {
        return librarianId;
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
     * Returns a string representing librarian details including librarian ID and user details.
     * 
     * @return formatted librarian details string
     */
    public String adminDetails() {
        return String.format("Librarian ID: %s | %s", librarianId, userDetails());
    }
}
