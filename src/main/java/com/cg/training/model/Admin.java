package com.cg.training.model;

/**
 * Represents an Admin user in the system.
 * <p>
 * This class extends {@link User} and inherits its properties such as name and email.
 * </p>
 * 
 * @author Gourav Patra
 */
public class Admin extends User {

    /**
     * Constructs a new Admin with the specified name and email.
     *
     * @param name  the name of the admin user
     * @param email the email address of the admin user
     */
    public Admin(String name, String email) {
        super(name, email);
    }
}
