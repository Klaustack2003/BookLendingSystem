package com.cg.training.daoImplementation;

import com.cg.training.dao.AdminDAO;
import com.cg.training.model.Admin;

import java.util.*;

/**
 * AdminDAOImplementation provides an in-memory implementation of the 
 * {@link AdminDAO} interface for managing Admin entities.
 * <p>
 * This implementation uses a {@link java.util.List} to store admin records 
 * and does not persist data to an external source.
 * </p>
 * 
 * @author Gourav Patra
 */
public class AdminDAOImplementation implements AdminDAO {

    /**
     * Internal list that holds Admin objects.
     */
    private final List<Admin> admins = new ArrayList<>();

    /**
     * Adds a new Admin to the internal list.
     *
     * @param admin the Admin object to be added; must not be null
     * @throws IllegalArgumentException if the admin is null
     */
    @Override
    public void addAdmin(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("Admin cannot be null");
        }
        admins.add(admin);
    }

    /**
     * Retrieves an unmodifiable list of all Admins.
     *
     * @return a List of Admin objects; may be empty if no admins are present
     */
    @Override
    public List<Admin> getAllAdmins() {
        return Collections.unmodifiableList(admins);
    }
}
