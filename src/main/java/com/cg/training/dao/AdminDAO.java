package com.cg.training.dao;

import com.cg.training.model.Admin;

import java.util.List;

/**
 * AdminDAO is a Data Access Object interface for performing operations 
 * related to Admin entities such as adding a new admin and retrieving 
 * all existing admins from the data source.
 * <p>
 * Implementations of this interface will define the persistence logic 
 * for handling Admin objects.
 * </p>
 * 
 * @author Gourav Patra
 */
public interface AdminDAO {

    /**
     * Adds a new Admin to the data source.
     *
     * @param admin the Admin object to be added; must not be null
     * @throws IllegalArgumentException if the admin is null or contains invalid data
     */
    void addAdmin(Admin admin);

    /**
     * Retrieves a list of all Admins from the data source.
     *
     * @return a List of Admin objects; may be empty if no admins are found
     */
    List<Admin> getAllAdmins();
}
