package com.cg.training.model;

/**
 * Abstract base class representing a user in the system.
 * <p>
 * Contains common attributes such as name and email, and provides
 * a method to retrieve user details.
 * </p>
 * 
 * @author Deeptangshu Saha
 */
public abstract class User {
    /**
     * The name of the user.
     */
    protected final String name;

    /**
     * The email address of the user.
     */
    protected final String email;

    /**
     * Constructs a User with the specified name and email.
     * 
     * @param name  the user's name
     * @param email the user's email address
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Returns a string representing the user's details.
     * 
     * @return formatted string containing the name and email of the user
     */
    public String userDetails() {
        return String.format("Name: %s | Email: %s", name, email);
    }
}
